package com.devmind.devtools;

import com.devmind.devtools.config.DevMindProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableConfigurationProperties(DevMindProperties.class)
public class DevMindApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevMindApplication.class, args);
    }
}
