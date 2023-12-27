package com.marty.first.api.repository;

import com.marty.first.api.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Martim Ramos
 */

@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Integer> {

    Boolean usernameTaken(String username);

}