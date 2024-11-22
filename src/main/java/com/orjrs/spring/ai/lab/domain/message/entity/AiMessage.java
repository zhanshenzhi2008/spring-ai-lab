package com.orjrs.spring.ai.lab.domain.message.entity;

import com.orjrs.spring.ai.lab.Infrastructure.jimmer.BaseEntity;
import com.orjrs.spring.ai.lab.domain.session.entity.AiSession;
import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.experimental.Accessors;
import org.babyfish.jimmer.sql.*;
import org.springframework.ai.chat.messages.MessageType;

import java.util.List;

/**
 * AI消息
 *
 * @author orjrs
 * {@code @date} 2024-11-05 21:01
 */
@Entity
public interface AiMessage extends BaseEntity {

    /** 消息类型(用户/助手/系统) */
    MessageType type();

    /** 消息内容 */
    String textContent();

    /** 媒介 */
    @Serialized
    @Nullable
    List<Media> medias();

    /** Session ID */
    @IdView
    String sessionId();

    /** 会话 */
    @ManyToOne
    @JoinColumn(name = "ai_session_id")
    @OnDissociate(DissociateAction.DELETE)
    AiSession session();

    @Data
    @Accessors(chain = true)
    class Media {

        /** 类型 */
        public String type;

        /** 数据 */
        public String data;
    }

}


