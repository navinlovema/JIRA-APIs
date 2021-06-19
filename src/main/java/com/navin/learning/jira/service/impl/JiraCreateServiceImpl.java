package com.navin.learning.jira.service.impl;

import com.navin.learning.jira.service.JiraCreateService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;

public class JiraCreateServiceImpl implements JiraCreateService {

    private final String url;
    private final HttpHeaders httpHeaders;

    public JiraCreateServiceImpl(
            @Value("${jira.url.create}") String url,
            @Qualifier("httpBasicHeader") HttpHeaders httpHeaders) {
        this.url = url;
        this.httpHeaders = httpHeaders;
    }

    @Override
    public void createStory() {

    }

    @Override
    public void createTask() {

    }

    @Override
    public void createSubTask() {

    }

    @Override
    public void createEpic() {

    }

    @Override
    public void createBug() {

    }


}
