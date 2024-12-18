package com.orjrs.spring.ai.lab.domain.阿根廷;

import com.orjrs.spring.ai.lab.Infrastructure.jimmer.BaseDateTime;
import com.orjrs.spring.ai.lab.Infrastructure.jimmer.UUIDIdGenerator;
import jakarta.annotation.Nullable;
import org.babyfish.jimmer.sql.*;

/**
 * 用户信息
 *
 * @author orjrs
 * {@code @date} 2024-11-05 21:01
 */
@Entity
@Table(name = "ai_lib.user")
public interface User extends BaseDateTime {
    @Id
    @GeneratedValue(generatorType = UUIDIdGenerator.class)
    String id();

    /** 手机号 */
    @Key
    String phone();

    /**  密码 */
    String password();

    /** 头像 */
    @Nullable
    String avatar();

    /** 昵称  */
    @Nullable
    String nickname();

    /** 性别  */
    @Nullable
    String gender();
//
//    /** 创建人ID  */
//    @Nonnull
//    String creatorId();
//
//    /** 更新人ID*/
//    @Nonnull
//    String modifierId();
}