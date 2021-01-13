package gaminglads.profileservice.controller;

import gaminglads.profileservice.exceptions.ProfileNotSavedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler
    public ResponseEntity<String> handleProfileNotSavedException(ProfileNotSavedException e) {
        log.error("Profile was not saved", e);
        return new ResponseEntity<>("Profile was not saved", HttpStatus.CONFLICT);
    }
}
