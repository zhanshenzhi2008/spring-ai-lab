package com.orjrs.spring.ai.lab.Infrastructure.jimmer;

import com.orjrs.spring.ai.lab.domain.user.entity.User;
import jakarta.annotation.Nullable;
import org.babyfish.jimmer.sql.*;
import org.babyfish.jimmer.sql.meta.UUIDIdGenerator;

import java.time.LocalDateTime;

/**
 * 实体通用属性
 *
 * @author orjrs
 * {@code @date} 2024-11-05 21:01
 */
@MappedSuperclass
public interface BaseEntity extends BaseDateTime {

    /** 主键 */
    @Id
    @GeneratedValue(generatorType = UUIDIdGenerator.class)
    String id();

    /** 创建者 */
    @ManyToOne
    @OnDissociate(DissociateAction.DELETE)
    @Nullable    User creator();

    /** 更新者 */
    @ManyToOne
    @OnDissociate(DissociateAction.DELETE)
    @Nullable    User modifier();
}