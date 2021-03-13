package com.example.Network.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Id Not Found")
public class NotFoundException extends Exception {

    public NotFoundException(String msg) {
        super(msg);
    }
}