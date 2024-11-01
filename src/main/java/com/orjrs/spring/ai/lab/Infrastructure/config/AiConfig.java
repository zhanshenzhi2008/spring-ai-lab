package com.orjrs.spring.ai.lab.Infrastructure.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ai相关配置
 *
 * @author orjrs
 * {@code @date} 2024-10-30 18:32
 */
@Configuration
class AiConfig {

    /**
     * OpenAi Chat client
     *
     * @param builder ChatClient.Builder
     * @return ChatClient
     */
    @Bean
    ChatClient chatClient(ChatClient.Builder builder) {
        return builder.build();
    }

}