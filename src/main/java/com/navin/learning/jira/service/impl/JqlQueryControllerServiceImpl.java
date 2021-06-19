package com.navin.learning.jira.service.impl;

import com.navin.learning.jira.service.JqlQueryControllerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class JqlQueryControllerServiceImpl implements JqlQueryControllerService {

    private final String url;
    private final HttpHeaders httpHeaders;

    public JqlQueryControllerServiceImpl(
            @Value("${jira.url.jql}") String url,
            @Qualifier("httpBasicHeader") HttpHeaders httpHeaders) {
        this.url = url;
        this.httpHeaders = httpHeaders;
    }


    @Override
    public String fetchJqlQueryResult(String jql) {
        String completeUrl = url + jql;
        RestTemplate restTemplate = new RestTemplate();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(httpHeaders);
        ResponseEntity<String> response = null;
        try{
            response = restTemplate.exchange(completeUrl, HttpMethod.GET, request, String.class);
        }catch (Exception e) {
           log.error("Error while searching result for JQL QUERY = " + jql, e);
        }
        assert response != null;
        return response.getBody();
    }
}
