package com.orjrs.spring.ai.lab.interfaces.web;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.orjrs.spring.ai.lab.Infrastructure.exception.BizException;
import com.orjrs.spring.ai.lab.domain.user.entity.User;
import com.orjrs.spring.ai.lab.domain.user.entity.UserDraft;
import com.orjrs.spring.ai.lab.domain.user.entity.dto.UserLoginInput;
import com.orjrs.spring.ai.lab.domain.user.entity.dto.UserRegisterInput;
import com.orjrs.spring.ai.lab.domain.user.resposity.UserRepository;
import lombok.AllArgsConstructor;
import org.babyfish.jimmer.client.FetchBy;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * 用户控制类
 *
 * @author orjrs
 * {@code @date} 2024-11-05 21:01
 */
@RequestMapping("user")
@RestController
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    /**
     * 查询用户信息
     *
     * @return User
     */
    @GetMapping
    public @FetchBy(value = "FETCHER", ownerType = UserRepository.class) User userInfo() {
        return userRepository.findById(StpUtil.getLoginIdAsString(), UserRepository.FETCHER)
                .orElseThrow(() -> new BizException("用户信息不存在"));
    }

    /**
     * 根据电话查询用户Token信息
     *
     * @return User
     */
    @PostMapping("login")
    public SaTokenInfo login(@RequestBody UserLoginInput input) {
        User databaseUser = userRepository.findByPhone(input.getPhone())
                .orElseThrow(() -> new BizException("用户名/密码错误"));
        if (!BCrypt.checkpw(input.getPassword(), databaseUser.password())) {
            throw new BizException("用户名/密码错误");
        }
        StpUtil.login(databaseUser.id());
        return StpUtil.getTokenInfo();
    }


    /**
     * 将指定账号强制注销
     * 前提：首先调用登录接口进行登录
     * @return SaResult
     */
    @PostMapping("logout")
    public  SaResult logout(@RequestBody Long userId) {

        // 强制注销等价于对方主动调用了注销方法，再次访问会提示：Token无效。
        StpUtil.logout(StpUtil.getLoginIdAsString());

        // 返回
        return SaResult.ok();
    }
    
    /**
     * 注册用户信息
     *
     * @return User
     */
    @PostMapping("register")
    public SaTokenInfo register(@RequestBody UserRegisterInput input) {
        Optional<User> byPhone = userRepository.findByPhone(input.getPhone());
        if (byPhone.isPresent()) {
            throw new BizException("手机号已存在, 请登录");
        }
        User save = userRepository.save(UserDraft.$.produce(draft -> {
            draft.setPhone(input.getPhone())
                    .setPassword(BCrypt.hashpw(input.getPassword()));
        }));
        StpUtil.login(save.id());
        return StpUtil.getTokenInfo();
    }
}