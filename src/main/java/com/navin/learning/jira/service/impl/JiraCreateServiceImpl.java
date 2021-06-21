package com.navin.learning.jira.service.impl;

import com.navin.learning.jira.model.CreateStory;
import com.navin.learning.jira.service.JiraCreateService;
import com.navin.learning.jira.util.CreateJiraHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;

@Slf4j
@Service
public class JiraCreateServiceImpl implements JiraCreateService {

    private final String url;
    private final HttpHeaders httpHeaders;
    private final String createFileName;

    public JiraCreateServiceImpl(
            @Value("${jira.url.create}") String url,
            @Qualifier("httpBasicHeader") HttpHeaders httpHeaders,
            @Value("${jira.create.inputFile}") String createFileName) {
        this.url = url;
        this.httpHeaders = httpHeaders;
        this.createFileName = createFileName;
    }

    private final CreateJiraHelper createJiraHelper = new CreateJiraHelper();

    public String createStory(CreateStory createStory) {
        ResponseEntity<String> response = null;
        try {
            String input = createJiraHelper.getJiraCreateInputData(createStory, createFileName);
            RestTemplate restTemplate = new RestTemplate();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            HttpEntity<String> request = new HttpEntity<>(input, httpHeaders);

            response = restTemplate.postForEntity(url, request, String.class);
        }catch (Exception e) {
            log.error("Error while making post call in JIRA...", e);
        }
        assert response != null;
        return response.getBody();
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
