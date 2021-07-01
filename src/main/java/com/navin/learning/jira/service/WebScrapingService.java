package com.navin.learning.jira.service;

import com.navin.learning.jira.model.CoronaData;

import java.io.IOException;
import java.util.List;

public interface WebScrapingService {
    public List<CoronaData> getCovidCases() throws IOException;
}
