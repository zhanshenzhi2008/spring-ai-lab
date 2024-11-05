package com.orjrs.spring.ai.lab.Infrastructure.jimmer;

import org.babyfish.jimmer.sql.meta.DatabaseNamingStrategy;
import org.babyfish.jimmer.sql.runtime.DefaultDatabaseNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Jimmer配置
 *
 * @author orjrs
 * {@code @date} 2024-11-05 21:01
 */
@Configuration
public class JimmerConfig {

  @Bean
  public DatabaseNamingStrategy databaseNamingStrategy() {
    return DefaultDatabaseNamingStrategy.LOWER_CASE;
  }
}