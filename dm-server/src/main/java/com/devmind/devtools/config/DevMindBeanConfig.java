package com.devmind.devtools.config;

import com.devmind.devtools.model.Session;
import com.devmind.devtools.model.Speaker;
import com.devmind.devtools.storage.JsonFileLoader;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dev-Mind <guillaume@dev-mind.fr>
 * @since 15/06/16.
 */
@Configuration
public class DevMindBeanConfig {

    @Bean
    public JsonFileLoader<Speaker> speakerJsonFileLoader(ObjectMapper objectMapper, DevMindProperties devMindProperties) {
        return new JsonFileLoader<>(objectMapper, devMindProperties, Speaker.class);
    }

    @Bean
    public JsonFileLoader<Session> sessionJsonFileLoader(ObjectMapper objectMapper, DevMindProperties devMindProperties) {
        return new JsonFileLoader<>(objectMapper, devMindProperties, Session.class);
    }
}
