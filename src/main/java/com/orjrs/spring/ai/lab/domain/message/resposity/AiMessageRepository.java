package com.orjrs.spring.ai.lab.domain.message.resposity;

import com.orjrs.spring.ai.lab.domain.message.entity.AiMessage;
import com.orjrs.spring.ai.lab.domain.message.entity.AiMessageTable;
import org.babyfish.jimmer.spring.repository.JRepository;

import java.util.List;

/**
 * AI消息Repository
 *
 * @author orjrs
 * {@code @date} 2024-11-05 21:01
 */
public interface AiMessageRepository extends JRepository<AiMessage, String> {
    AiMessageTable t = AiMessageTable.$;

    default List<AiMessage> findBySessionId(String sessionId, int lastN) {
        return sql()
                .createQuery(t)
                .where(t.sessionId().eq(sessionId))
                .orderBy(t.createdTime().asc())
                .select(t)
                .limit(lastN)
                .execute();
    }

    default Integer deleteBySessionId(String sessionId) {
        return sql().createDelete(t)
                .where(t.sessionId().eq(sessionId))
                .execute();
    }
}