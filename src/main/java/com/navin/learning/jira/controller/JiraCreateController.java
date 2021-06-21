package com.navin.learning.jira.controller;

import com.navin.learning.jira.model.CreateStory;
import com.navin.learning.jira.service.JiraCreateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
public class JiraCreateController {

    @Autowired
    private JiraCreateService jiraCreateService;

    @GetMapping(value = "/jiraHealth")
    public String getHealthCheck() {
        return "Jira Create Controller Up and Running";
    }

    @PostMapping(value = "/createJiraStory")
    public ResponseEntity<String> createStory(@RequestBody CreateStory createStory, BindingResult result) throws IOException {
        log.info("Inside the Create JIRA Story Controller...");

        if (result.hasErrors()) {
            log.error("Error in the send parameter...");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        String response = jiraCreateService.createStory(createStory);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
