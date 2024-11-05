package com.orjrs.spring.ai.lab.domain.session.entity;

import com.orjrs.spring.ai.lab.Infrastructure.jimmer.BaseEntity;
import com.orjrs.spring.ai.lab.domain.message.entity.AiMessage;
import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.OneToMany;
import org.babyfish.jimmer.sql.OrderedProp;

import java.util.List;

/**
 * 会话
 *
 * @author orjrs
 * {@code @date} 2024-11-05 21:01
 */
@Entity
public interface AiSession extends BaseEntity {

    /**  会话名称 */
    String name();

    /** 一对多关联消息，按创建时间升序 */
    @OneToMany(mappedBy = "session", orderedProps = @OrderedProp(value = "createdTime"))
    List<AiMessage> messages();
}