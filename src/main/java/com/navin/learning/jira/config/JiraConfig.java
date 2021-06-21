package com.navin.learning.jira.config;


import com.sun.org.apache.bcel.internal.generic.INEG;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executor;

@Configuration
public class JiraConfig {

    @Bean
    public Executor initialisedInitialExecutor(
            @Value("${queueSize}") Integer queueSize,
            @Value("${coreSize}")Integer coreSize,
            @Value("${poolSize}") Integer poolSize
            ) {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(coreSize);
        executor.setMaxPoolSize(poolSize);
        executor.setQueueCapacity(queueSize);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix("TestExecutor-");
        executor.initialize();
        return executor;
    }

    @Bean(name = "httpBasicHeader")
    public HttpHeaders getInitialisedUserNamePass(
            @Value("${jira.user.name}") String userName,
            @Value("${jira.user.password}") String password) {
        HttpHeaders httpHeaders = new HttpHeaders();
        String plainAuth = userName + ":" + password;
        byte[] plainCredsBytes = plainAuth.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);
        httpHeaders.add("Authorization", "Basic " + base64Creds);

        return httpHeaders;
    }

}
