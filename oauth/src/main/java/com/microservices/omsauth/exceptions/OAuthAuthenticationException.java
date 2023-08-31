package com.microservices.omsauth.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author bilal.ashraf
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class OAuthAuthenticationException extends RuntimeException {
    public OAuthAuthenticationException(String message) {
        super(message);
    }
}