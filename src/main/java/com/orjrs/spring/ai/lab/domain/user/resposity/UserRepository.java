package com.orjrs.spring.ai.lab.domain.user.resposity;

import com.orjrs.spring.ai.lab.domain.user.entity.User;
import com.orjrs.spring.ai.lab.domain.user.entity.UserFetcher;
import com.orjrs.spring.ai.lab.domain.user.entity.UserTable;
import org.babyfish.jimmer.spring.repository.JRepository;

import java.util.Optional;
/**
 * 用户信息Repository
 *
 * @author orjrs
 * {@code @date} 2024-11-08 21:01
 */
public interface UserRepository extends JRepository<User, String> {
    UserTable t = UserTable.$;
    UserFetcher FETCHER = UserFetcher.$.allScalarFields();

    default Optional<User> findByPhone(String phone) {
        return sql().createQuery(t)
                .where(t.phone().eq(phone))
                .select(t)
                .fetchOptional();
    }
}