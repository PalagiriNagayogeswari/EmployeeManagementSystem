package com.bridgelabz.EmployeeManagementSystem.exception;


//IdNotFound exception occurs when we cant find the id in the database.
public class IdNotFoundException extends Exception {
    public IdNotFoundException(String message){
        super(message);
    }
}
