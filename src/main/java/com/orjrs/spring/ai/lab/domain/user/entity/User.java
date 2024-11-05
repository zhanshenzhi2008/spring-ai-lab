package com.orjrs.spring.ai.lab.domain.user.entity;

import com.orjrs.spring.ai.lab.Infrastructure.jimmer.BaseDateTime;
import jakarta.annotation.Nullable;
import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.GeneratedValue;
import org.babyfish.jimmer.sql.Id;
import org.babyfish.jimmer.sql.Key;
import org.babyfish.jimmer.sql.meta.UUIDIdGenerator;

/**
 * 用户信息
 *
 * @author orjrs
 * {@code @date} 2024-11-05 21:01
 */
@Entity
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
    @Null
    String nickname();

    /** 性别  */
    @Null
    String gender();
}