package com.navin.learning.jira.controller;

import com.navin.learning.jira.service.JqlQueryControllerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
public class JqlQueryController {

    @Autowired
    JqlQueryControllerService jqlQueryControllerService;

    @GetMapping("/jqlHealth")
    public ResponseEntity<String> getHealth() {
        return new ResponseEntity<>("Hi, welcome to JQL API's", HttpStatus.OK);
    }

    @GetMapping("/jqlSearch")
    public ResponseEntity<String> getJqlResult(@RequestParam String jqlQuery) {
        log.info("Inside the JQL Search Rest API...");
        if(jqlQuery.isEmpty())
            return new ResponseEntity<>("bad request", HttpStatus.BAD_REQUEST);

        String output = jqlQueryControllerService.fetchJqlQueryResult(jqlQuery);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }
}
