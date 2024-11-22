package com.orjrs.spring.ai.lab.domain.session.resposity;

import cn.dev33.satoken.stp.StpUtil;
import com.orjrs.spring.ai.lab.domain.message.entity.AiMessageFetcher;
import com.orjrs.spring.ai.lab.domain.session.entity.AiSession;
import com.orjrs.spring.ai.lab.domain.session.entity.AiSessionFetcher;
import com.orjrs.spring.ai.lab.domain.session.entity.AiSessionTable;
import org.babyfish.jimmer.spring.repository.JRepository;

import java.util.List;

/**
 * 用户会话Repository
 *
 * @author orjrs
 * {@code @date} 2024-11-22 10:01
 */
public interface AiSessionRepository extends JRepository<AiSession, String> {
    AiSessionTable t = AiSessionTable.$;
    AiSessionFetcher FETCHER = AiSessionFetcher.$.allScalarFields()
            .messages(AiMessageFetcher.$.allScalarFields().sessionId());

    default List<AiSession> findByUser() {
        return sql().createQuery(t)
                .where(t.creatorId().eq(StpUtil.getLoginIdAsString()))
                .select(t.fetch(FETCHER))
                .execute();
    }
}