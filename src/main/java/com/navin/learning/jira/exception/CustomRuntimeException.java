package com.navin.learning.jira.exception;

public class CustomRuntimeException extends RuntimeException{

    public CustomRuntimeException(Throwable cause) {
        super();
    }

    public CustomRuntimeException(String message) {
        super(message);
    }
}
