package com.navin.learning.jira.service;

public interface JiraCreateService {

    //work management issue type
    public void createTask();
    public void createSubTask();

    //software issue types
    public void createEpic();
    public void createBug();
    public void createStory();


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
