package com.navin.learning.jira.util;

import com.navin.learning.jira.model.CreateStory;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
public class CreateJiraHelper {

    public String getJiraCreateInputData(CreateStory createStory, String filePath) {
        log.info("Create JIRA parameter Making Started...");
        String content = "";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            reader.close();

            content = stringBuilder.toString();
            content = content.replace("<projectId>", createStory.getProjectId());
            content = content.replace("<projectKey>", createStory.getProjectKey());
            content = content.replace("<projectName>", createStory.getProjectName());
            content = content.replace("<summary>", createStory.getSummary());
            content = content.replace("<description>", createStory.getDescription());
            content = content.replace("<issueType>", createStory.getIssueType());

        }catch (IOException e) {
            log.error("unable to read file from FILEPATH: " + filePath, e);
        }catch (Exception e) {
            log.error("Error while building INPUT for Create JIRA...");
        }
        return content;
    }
}
