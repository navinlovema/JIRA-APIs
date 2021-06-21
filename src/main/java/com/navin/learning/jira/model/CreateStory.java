package com.navin.learning.jira.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateStory {

    @NotBlank
    private String projectId;
    @NotBlank
    private String projectKey;
    @NotBlank
    private String projectName;
    @NotBlank
    private String summary;
    @NotBlank
    private String description;
    @NotBlank
    private String issueType;
    /*@NotBlank
    private String originalEstimation;
    @NotBlank
    private String remainingEstimation;*/
    /*@NotBlank
    private String customField_11050;*/
}
