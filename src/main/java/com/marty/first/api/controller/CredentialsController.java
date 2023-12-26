package com.marty.first.api.controller;

import com.marty.first.api.entity.Credentials;
import com.marty.first.api.handler.RequestHandler;
import com.marty.first.api.service.CredentialsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author Martim Ramos
 */

@RestController
@RequestMapping("marty/api/v1/credentials")
public class CredentialsController extends RequestHandler {

    private final CredentialsService credentialsService;

    /**
     * Constructor
     * @param credentialsService CredentialsService
     */
    public CredentialsController(CredentialsService credentialsService) {
        this.credentialsService = credentialsService;
    }

    /**
     *
     * @return CredentialsService
     */
    public CredentialsService getCredentialsService() {
        return credentialsService;
    }

    /**
     * Gets all the credentials
     * @return a list of credentials
     */
    @GetMapping
    public List<Credentials> getAllCredentials() {
        return getCredentialsService().getAllCredentials();
    }

    /**
     * Gets credentials by ID
     * @param id Integer
     * @return credentials
     */
    @GetMapping("{id}")
    public Credentials getCredentialsByID(@PathVariable("id") Integer id) {
        return getCredentialsService().getCredentialsByID(id);
    }

    /**
     * Updates existing credentials
     * @param request CredentialsRequest
     * @param id Integer
     */
    @PutMapping("{id}")
    public void updateCredentialsByID(@RequestBody CredentialsRequest request, @PathVariable("id") Integer id) {
        getCredentialsService().updateCredentialsByID(request, id);
    }

    /**
     * equals method
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CredentialsController that = (CredentialsController) o;
        return Objects.equals(credentialsService, that.credentialsService);
    }

    /**
     * hashCode method
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(credentialsService);
    }

    /**
     * toString method
     * @return String
     */
    @Override
    public String toString() {
        return "CredentialsController { " +
                "credentialsService = " + credentialsService +
                " }";
    }

}
