package com.producerapi.producerapidemo.service;

public class TaskNotFoundException extends Exception{

//    public TaskNotFoundException(){
//
//    }

    public TaskNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public TaskNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
