package com.navin.learning.jira.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateStory {
    private String projectId;
    private String projectKey;
    private String projectName;
    private String summary;
    private String description;
    private String issueType;
    private String originalEstimation;
    private String remainingEstimation;
    private String customField_11050;
}
