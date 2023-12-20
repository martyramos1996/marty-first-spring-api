package com.marty.first.api.handler;

import com.marty.first.api.entity.Credentials;
import com.marty.first.api.enums.Gender;

/**
 * @author Martim Ramos
 */

public class RequestHandler {

    /**
     * The credentials request
     * @param username String
     * @param password String
     */
    public record CredentialsRequest(String username, String password) {}

    /**
     * The customer request
     * @param name String
     * @param age Integer
     * @param email String
     * @param gender Gender
     * @param credentials Credentials
     */
    public record CustomerRequest(String name, Integer age, String email, Gender gender, Credentials credentials) {}

}
