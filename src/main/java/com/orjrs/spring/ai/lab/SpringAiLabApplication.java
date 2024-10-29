package com.orjrs.spring.ai.lab;

import org.babyfish.jimmer.client.EnableImplicitApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 启动类
 *
 * @author orjrs
 * {@code @date} 2024-10-17 13:23:53
 **/
@EnableImplicitApi //启动自动生成客户端的能力
@SpringBootApplication
public class SpringAiLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiLabApplication.class, args);
    }

}
