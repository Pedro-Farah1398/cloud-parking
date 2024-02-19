package com.cloudproject.parking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoParkingFoundException extends RuntimeException{
    public NoParkingFoundException(String id) {
        super("It was not possible to find parking with id: " + id);
    }
}
