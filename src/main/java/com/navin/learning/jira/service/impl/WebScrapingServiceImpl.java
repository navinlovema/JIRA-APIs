package com.navin.learning.jira.service.impl;

import com.navin.learning.jira.model.CoronaData;
import com.navin.learning.jira.service.WebScrapingService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class WebScrapingServiceImpl implements WebScrapingService {
    @Override
    public List<CoronaData> getCovidCases() throws IOException {
        List<CoronaData> finalData = new ArrayList<>();
        try{
            Document webPage = Jsoup.connect("https://en.wikipedia.org/wiki/COVID-19_pandemic_by_country_and_territory").get();
            Element tbody = webPage.getElementById("thetable").getElementsByTag("tbody").get(0);
            Elements rows = tbody.children();
            int i =0;
            for (Element eachRow : rows) {
                i = i + 1;
                if (i > 2) {
                    CoronaData coronaData = new CoronaData();
                    coronaData.setCountry(eachRow.getElementsByTag("a").get(0).text());
                    Elements tds = eachRow.getElementsByTag("td");
                    if (tds.size() > 3) {
                        coronaData.setCases(tds.get(0).text().replace(",", ""));
                        coronaData.setDeaths(tds.get(1).text().replace(",", ""));
                        coronaData.setRecoveries(tds.get(2).text().replace(",", ""));
                    }
                    finalData.add(coronaData);
                }
            }
        }catch (Exception e)
        {
            log.error("Error while web scraping the website URL: https://en.wikipedia.org/wiki/COVID-19_pandemic_by_country_and_territory");
        }

        return finalData;
    }
}
