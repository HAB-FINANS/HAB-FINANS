package com.habfinans.habfinans.Models;

public class ObjectAnswer {
    private Object object;
    private String message;

    //Constructor
    public ObjectAnswer(String message,Object object) {
        this.object = object;
        this.message = message;
    }

    //Constructor Empty
    public ObjectAnswer() {
    } 

    
    //Getters and Setters
    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    
    
}
