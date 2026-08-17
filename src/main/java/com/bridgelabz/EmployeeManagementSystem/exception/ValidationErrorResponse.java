package com.bridgelabz.EmployeeManagementSystem.exception;

import java.util.Map;


//Validation exception occurs when the user entered data fails the validations required.
public class ValidationErrorResponse {

    private int status;
    private String message;
    private Map<String, String> errors;

    public ValidationErrorResponse(
            int status,
            String message,
            Map<String, String> errors) {

        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}