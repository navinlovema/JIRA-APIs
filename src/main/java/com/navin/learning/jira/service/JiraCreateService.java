package com.navin.learning.jira.service;

import com.navin.learning.jira.model.CreateStory;

import java.io.IOException;

public interface JiraCreateService {

    //work management issue type
    public void createTask();
    public void createSubTask();

    //software issue types
    public void createEpic();
    public void createBug();
    public String createStory(CreateStory createStory) throws IOException;


    /*
    will write it later...
    //service management
    public void createChange();
    public void createIncident();
    public void createNewFeature();
    public void createProblem();
    public void createServiceRequest();
    public void createSupport();*/
}
