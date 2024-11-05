package com.orjrs.spring.ai.lab.Infrastructure.jimmer;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 实体通用时间属性拦截器
 *
 * @author orjrs
 * {@code @date} 2024-11-05 21:01
 */
@Component
@AllArgsConstructor
public class BaseDateTimeDraftInterceptor implements
    DraftInterceptor<BaseDateTime, BaseDateTimeDraft> {


  @Override
  public void beforeSave(@NotNull BaseDateTimeDraft draft, BaseDateTime baseDateTime) {
    draft.setEditedTime(LocalDateTime.now());
    if (baseDateTime == null) {
      draft.setCreatedTime(LocalDateTime.now());
    }
  }
}