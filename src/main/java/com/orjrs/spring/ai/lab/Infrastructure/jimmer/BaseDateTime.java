package com.orjrs.spring.ai.lab.Infrastructure.jimmer;

import org.babyfish.jimmer.sql.MappedSuperclass;

import java.time.LocalDateTime;
/**
 * 实体通用时间属性
 *
 * @author orjrs
 * {@code @date} 2024-11-05 21:01
 */
@MappedSuperclass
public interface BaseDateTime {

  /** 创建时间 */
  LocalDateTime createdTime();

  /** 修改时间 */
  LocalDateTime modifiedTime();
}