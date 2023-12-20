package com.marty.first.api.repository;

import com.marty.first.api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Martim Ramos
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN TRUE ELSE FALSE END FROM Customer c WHERE c.email = ?1")
    Boolean emailTaken(String email);

}
