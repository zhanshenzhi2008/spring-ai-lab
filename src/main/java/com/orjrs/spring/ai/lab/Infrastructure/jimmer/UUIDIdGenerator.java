package com.orjrs.spring.ai.lab.Infrastructure.jimmer;

import cn.hutool.core.util.IdUtil;
import org.babyfish.jimmer.sql.meta.UserIdGenerator;
/**
 * 用户ID的生成器
 *
 * @author orjrs
 * {@code @date} 2024-11-15 11:01
 */
public class UUIDIdGenerator implements UserIdGenerator<String> {

  public UUIDIdGenerator() {
  }

  public String generate(Class<?> entityType) {
    return IdUtil.fastSimpleUUID();
  }
}