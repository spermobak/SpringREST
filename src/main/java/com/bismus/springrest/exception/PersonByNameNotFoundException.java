package com.bismus.springrest.exception.custonExceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonByNameNotFoundException extends RuntimeException{
    private final String personName;

    @Override
    public String getMessage() {
        return "Profile with name = " + personName + " not found";
    }
}
