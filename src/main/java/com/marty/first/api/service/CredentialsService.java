package com.marty.first.api.service;

import com.marty.first.api.entity.Credentials;
import com.marty.first.api.exception.BadRequestException;
import com.marty.first.api.exception.NotFoundException;
import com.marty.first.api.handler.RequestHandler;
import com.marty.first.api.repository.CredentialsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author Martim Ramos
 */

@Service
public class CredentialsService extends RequestHandler {

    private final CredentialsRepository credentialsRepository;

    /**
     * Constructor
     * @param credentialsRepository CredentialsRepository
     */
    public CredentialsService(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

    /**
     * Counts all the credentials
     * @return the credentials count
     */
    public Long countAllCredentials() {
        return getCredentialsRepository().count();
    }

    /**
     * Gets all the credentials
     * @return a list of credentials
     */
    public List<Credentials> getAllCredentials() {
        return getCredentialsRepository().findAll();
    }

    /**
     * Gets credentials by ID
     * @param id Integer
     * @return credentials
     */
    public Credentials getCredentialsByID(Integer id) {
        if (!getCredentialsRepository().existsById(id)) {
            throw new NotFoundException("There are no Credentials with the ID " + id);
        }
        return getCredentialsRepository().findById(id).isPresent()
                ? getCredentialsRepository().findById(id).get() : null;
    }

    /**
     * Adds new credentials
     * @param cs Credentials
     */
    public void addCredentials(Credentials cs) {
        if (getCredentialsRepository().usernameTaken(cs.getUsername())) {
            throw new BadRequestException("The username " + cs.getUsername() + " is already taken");
        }
        getCredentialsRepository().save(cs);
    }

    /**
     * Updates existing credentials
     * @param request CredentialsRequest
     * @param id Integer
     */
    public void updateCredentialsByID(CredentialsRequest request, Integer id) {
        if (!getCredentialsRepository().existsById(id)) {
            throw new NotFoundException("There are no Credentials with the ID " + id);
        }

        Credentials cs = getCredentialsRepository().findById(id).isPresent()
                ? getCredentialsRepository().findById(id).get() : null;

        if (cs != null) {
            credentialsUpdater(cs, request);
            getCredentialsRepository().save(cs);
        }
    }

    /**
     * Credentials update logic
     * @param cs Credentials
     * @param request CredentialsRequest
     */
    private void credentialsUpdater(Credentials cs, CredentialsRequest request) {
        if (request.username() != null) {
            if (getCredentialsRepository().usernameTaken(request.username())) {
                throw new BadRequestException("The username " + request.username() + " is already taken");
            }
            cs.setUsername(request.username());
        }
        if (request.password() != null) {
            cs.setUsername(request.password());
        }
    }

    /**
     * Deletes existing credentials by ID
     * @param id Integer
     */
    public void deleteCredentialsByID(Integer id) {
        if (!getCredentialsRepository().existsById(id)) {
            throw new NotFoundException("There are no Credentials with the ID " + id);
        }
        getCredentialsRepository().deleteById(id);
    }

    /**
     *
     * @return CredentialsRepository
     */
    public CredentialsRepository getCredentialsRepository() {
        return credentialsRepository;
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
        CredentialsService that = (CredentialsService) o;
        return Objects.equals(credentialsRepository, that.credentialsRepository);
    }

    /**
     * hashCode method
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(credentialsRepository);
    }

    /**
     * toString method
     * @return String
     */
    @Override
    public String toString() {
        return "CredentialsService { " +
                "credentialsRepository = " + credentialsRepository +
                " }";
    }
}
