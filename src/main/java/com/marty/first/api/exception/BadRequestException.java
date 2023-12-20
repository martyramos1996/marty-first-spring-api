package com.marty.first.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Martim Ramos
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    /**
     * BadRequestException
     * @param message String
     */
    public BadRequestException(String message) {
        super(message);
    }
}
