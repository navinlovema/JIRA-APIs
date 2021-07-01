package com.navin.learning.jira.controller.web.scraping;


import com.google.gson.Gson;
import com.navin.learning.jira.model.CoronaData;
import com.navin.learning.jira.service.WebScrapingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
public class WebScrapingController {

    @Autowired
    private WebScrapingService webScrapingService;

    @GetMapping(value = "/webScraping/health")
    public String webScrapingHealthCheck(){
        return "welcome to Web Scraping API...";
    }

    @GetMapping(value = "/webScraping/coronaData")
    public ResponseEntity<String> getCoronaReportFromURl() throws IOException {
        List<CoronaData> data = webScrapingService.getCovidCases();
        Gson gson = new Gson();
        String finalData = gson.toJson(data.toString());
        return new ResponseEntity<>(finalData, HttpStatus.OK);
    }

}
