package com.ns.carrental.controller;

import com.ns.carrental.exception.ImageOverSizeException;
import com.ns.carrental.exception.RecordExistException;
import com.ns.carrental.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends RuntimeException{

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<String> handleUserNotFoundException
            (RecordNotFoundException ex) {
        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ImageOverSizeException.class)
    public final ResponseEntity<String> handleUserNotFoundException
            (ImageOverSizeException ex) {
        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RecordExistException.class)
    public final ResponseEntity<String> handleUserNotFoundException
            (RecordExistException ex) {
        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }


}
