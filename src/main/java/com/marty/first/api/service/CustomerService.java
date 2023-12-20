package com.marty.first.api.service;

import com.marty.first.api.entity.Customer;
import com.marty.first.api.exception.BadRequestException;
import com.marty.first.api.exception.NotFoundException;
import com.marty.first.api.handler.RequestHandler;
import com.marty.first.api.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author Martim Ramos
 */

@Service
public class CustomerService extends RequestHandler {

    private final CustomerRepository customerRepository;

    /**
     * Constructor
     * @param customerRepository CustomerRepository
     */
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Counts all the customers
     * @return the customer count
     */
    public Long countAllCustomers() {
        return getCustomerRepository().count();
    }

    /**
     * Gets all the customers
     * @return a list of customers
     */
    public List<Customer> getAllCustomers() {
        return getCustomerRepository().findAll();
    }

    /**
     * Gets a customer by ID
     * @param id Integer
     * @return a customer
     */
    public Customer getCustomerbyID(Integer id) {
        if (!getCustomerRepository().existsById(id)) {
            throw new NotFoundException("There is no Customer with the ID " + id);
        }
        return getCustomerRepository().findById(id).isPresent()
                ? getCustomerRepository().findById(id).get() : null;
    }

    /**
     * Adds a new customer
     * @param c Customer
     */
    public void addCustomer(Customer c) {
        if (getCustomerRepository().emailTaken(c.getEmail())) {
            throw new BadRequestException("The email " + c.getEmail() + " is already taken");
        }
        getCustomerRepository().save(c);
    }

    /**
     * Updates an existing customer
     * @param request CustomerRequest
     * @param id Integer
     */
    public void updateCustomerByID(CustomerRequest request, Integer id) {
        if (!getCustomerRepository().existsById(id)) {
            throw new NotFoundException("There is no Customer with the ID " + id);
        }

        Customer c = getCustomerRepository().findById(id).isPresent()
                ? getCustomerRepository().findById(id).get() : null;

        if (c != null) {
            customerUpdater(c, request);
            getCustomerRepository().save(c);
        }
    }

    /**
     * Customer update logic
     * @param c Customer
     * @param request CustomerRequest
     */
    private void customerUpdater(Customer c, CustomerRequest request) {
        if (request.name() != null) {
            c.setName(request.name());
        }
        if (request.age() != null) {
            c.setAge(request.age());
        }
        if (request.email() != null) {
            if (getCustomerRepository().emailTaken(request.email())) {
                throw new BadRequestException("The email " + request.email() + " is already taken");
            }
            c.setEmail(request.email());
        }
        if (request.gender() != null) {
            c.setGender(request.gender());
        }
    }

    /**
     * Deletes an existing customer by ID
     * @param id Integer
     */
    public void deleteCustomerByID(Integer id) {
        if (!getCustomerRepository().existsById(id)) {
            throw new NotFoundException("There is no Customer with the ID " + id);
        }
        getCustomerRepository().deleteById(id);
    }

    /**
     *
     * @return CustomerRepository
     */
    public CustomerRepository getCustomerRepository() {
        return customerRepository;
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
        CustomerService that = (CustomerService) o;
        return Objects.equals(customerRepository, that.customerRepository);
    }

    /**
     * hashCode method
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(customerRepository);
    }

    /**
     * toString method
     * @return String
     */
    @Override
    public String toString() {
        return "CustomerService { " +
                "customerRepository = " + customerRepository +
                " }";
    }
}
