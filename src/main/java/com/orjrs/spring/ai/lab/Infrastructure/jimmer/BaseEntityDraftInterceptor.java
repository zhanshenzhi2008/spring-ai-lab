package com.orjrs.spring.ai.lab.Infrastructure.jimmer;

import cn.dev33.satoken.stp.StpUtil;
import lombok.AllArgsConstructor;
import org.babyfish.jimmer.sql.DraftInterceptor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

/**
 * 实体通用属性拦截器
 *
 * @author orjrs
 * {@code @date} 2024-11-05 21:01
 */
@Component
@AllArgsConstructor
public class BaseEntityDraftInterceptor implements DraftInterceptor<BaseEntity, BaseEntityDraft> {


  @Override
  public void beforeSave(@NotNull BaseEntityDraft draft, BaseEntity baseEntity) {
    draft.applyModifier(user -> {
      user.setId(StpUtil.getLoginIdAsString());
    });
    if (baseEntity == null) {
      draft.applyCreator(user -> {
        user.setId(StpUtil.getLoginIdAsString());
      });
    }
  }
}