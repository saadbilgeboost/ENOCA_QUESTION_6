package com.saad.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {
    INTERNAL_ERROR(2000, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error", BAD_REQUEST),
    COMPANY_NAME_DUPLICATE(1003, "This company already exists.", INTERNAL_SERVER_ERROR),
    COMPANY_NOT_FOUND(1004, "Company not found", INTERNAL_SERVER_ERROR),
    COMPANY_NOT_CREATED(1005, "Company could not be saved", INTERNAL_SERVER_ERROR),
    COMPANY_NOT_UPDATED(1008, "Company information could not be updated.", INTERNAL_SERVER_ERROR),
    COMPANY_NOT_DELETED(1009, "Company could not be deleted.", INTERNAL_SERVER_ERROR),
    EMPLOYEE_IDENTITY_NUMBER_DUPLICATE(3001, "This employee aldready exists in the database.", INTERNAL_SERVER_ERROR),
    EMPLOYEE_NOT_FOUND(3002, "Employee not found", INTERNAL_SERVER_ERROR),
    EMPLOYEE_NOT_CREATED(3003, "Employee could not be saved", INTERNAL_SERVER_ERROR),
    EMPLOYEE_NOT_UPDATED(3004, "Employee information could not be updated.", INTERNAL_SERVER_ERROR),
    EMPLOYEE_NOT_DELETED(3005, "Employee could not be deleted.", INTERNAL_SERVER_ERROR);
    private int code;
    private String message;
    HttpStatus httpStatus;
}
