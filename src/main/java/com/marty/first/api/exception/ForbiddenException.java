package com.marty.first.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Martim Ramos
 */

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {

    /**
     * ForbiddenException
     * @param message String
     */
    public ForbiddenException(String message) {
        super(message);
    }
}
