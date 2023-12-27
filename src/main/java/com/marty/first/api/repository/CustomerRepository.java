package com.marty.first.api.repository;

import com.marty.first.api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Martim Ramos
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Boolean emailTaken(String email);

    Customer findByCredentialsId(Integer credentialsId);

}
