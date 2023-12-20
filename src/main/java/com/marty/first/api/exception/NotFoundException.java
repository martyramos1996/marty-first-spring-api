package com.marty.first.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Martim Ramos
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    /**
     * NotFoundException
     * @param message String
     */
    public NotFoundException(String message) {
        super(message);
    }
}
