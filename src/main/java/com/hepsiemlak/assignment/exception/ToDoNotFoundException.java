package com.hepsiemlak.assignment.exception;

public class ToDoNotFoundException extends RuntimeException {

    public ToDoNotFoundException(String id) {
        super("Given resource not found !");
    }

}
