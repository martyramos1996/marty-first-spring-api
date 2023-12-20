package com.marty.first.api.repository;

import com.marty.first.api.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Martim Ramos
 */

@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Integer> {

    @Query("SELECT CASE WHEN COUNT(cs) > 0 THEN TRUE ELSE FALSE END FROM Credentials cs WHERE cs.username = ?1")
    Boolean usernameTaken(String username);

}