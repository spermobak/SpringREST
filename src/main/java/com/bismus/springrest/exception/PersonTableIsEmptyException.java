package com.bismus.springrest.exception.custonExceptions;

public class PersonTableIsEmptyException extends RuntimeException{

    @Override
   public String getMessage(){
        return "Table of person is empty.";
    }
}
