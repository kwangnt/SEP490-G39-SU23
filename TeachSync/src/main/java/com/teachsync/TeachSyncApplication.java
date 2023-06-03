package com.teachsync;

import com.teachsync.utils.MiscUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TeachSyncApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TeachSyncApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TeachSyncApplication.class, args);
    }

    @Bean
    public MiscUtil miscUtil() {
        return new MiscUtil();
    }
}