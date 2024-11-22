package com.orjrs.spring.ai.lab.domain.message.vo;

import com.orjrs.spring.ai.lab.domain.message.entity.dto.AiMessageInput;
import lombok.Data;


/**
 * AI消息包装器
 *
 * @author orjrs
 * {@code @date} 2024-11-22 21:01
 */
@Data
public class AiMessageWrapper {

    /**AI消息入参 */
    AiMessageInput message;

    /**AI消息参数 */
    AiMessageParams params;
}