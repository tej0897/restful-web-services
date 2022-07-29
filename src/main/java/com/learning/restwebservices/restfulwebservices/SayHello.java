package com.learning.restwebservices.restfulwebservices;

public class SayHello {
    private String message;

    public SayHello(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SayHello{" +
                "message='" + message + '\'' +
                '}';
    }
}
