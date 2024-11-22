package com.orjrs.spring.ai.lab.domain.message.vo;

import lombok.Data;

/**
 * AI消息参数
 *
 * @author orjrs
 * {@code @date} 2024-11-22 21:01
 */
@Data
public class AiMessageParams {
    Boolean enableVectorStore;
    Boolean enableAgent;
}