package com.marty.first.api.controller;

import com.marty.first.api.entity.Credentials;
import com.marty.first.api.entity.Customer;
import com.marty.first.api.service.CredentialsService;
import com.marty.first.api.service.CustomerService;
import com.marty.first.api.handler.RequestHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author Martim Ramos
 */

@RestController
@RequestMapping("marty/api/v1/customers")
public class CustomerController extends RequestHandler {

    private final CustomerService customerService;
    private final CredentialsService credentialsService;
    private final CredentialsController credentialsController;

    /**
     * Constructor
     * @param customerService CustomerService
     */
    public CustomerController(CustomerService customerService, CredentialsService credentialsService, CredentialsController credentialsController) {
        this.customerService = customerService;
        this.credentialsService = credentialsService;
        this.credentialsController = credentialsController;
    }

    /**
     * Gets all the customers
     * @return a list of customers
     */
    @GetMapping
    public List<Customer> getAllCustomers() {
        return getCustomerService().getAllCustomers();
    }

    /**
     * Gets a customer by ID
     * @param id Integer
     * @return a customer
     */
    @GetMapping("{id}")
    public Customer getCustomerbyID(@PathVariable("id") Integer id) {
        return getCustomerService().getCustomerbyID(id);
    }

    /**
     * Adds a Customer and its Credentials
     * @param request CustomerWithCredentialsRequest
     */
    @PostMapping
    public void addCustomerWithCredentials(@RequestBody CustomerWithCredentialsRequest request) {
        Credentials credentials = request.credentials();
        Customer customer = request.customer();
        getCredentialsController().addCredentials(credentials);
        if (credentials.getId() != null) {
            customer.setCredentials(credentials);
            getCustomerService().addCustomer(customer);
        }

    }

    /**
     * Updates an existing customer
     * @param request CustomerRequest
     * @param id Integer
     */
    @PutMapping("{id}")
    public void updateCustomerByID(@RequestBody CustomerRequest request, @PathVariable("id") Integer id) {
        getCustomerService().updateCustomerByID(request, id);
    }

    /**
     * Deletes an existing customer by ID
     * @param id Integer
     */
    @DeleteMapping("{id}")
    public void deleteCustomerByID(@PathVariable("id") Integer id) {
        Credentials cs = getCustomerService().getCustomerbyID(id).getCredentials();
        getCustomerService().deleteCustomerByID(id);
        getCredentialsService().deleteCredentialsByID(cs.getId());
    }

    /**
     *
     * @return CustomerService
     */
    public CustomerService getCustomerService() {
        return customerService;
    }

    /**
     *
     * @return CredentialsService
     */
    public CredentialsService getCredentialsService() {
        return credentialsService;
    }

    /**
     *
     * @return CredentialsService
     */
    public CredentialsController getCredentialsController() {
        return credentialsController;
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
        CustomerController that = (CustomerController) o;
        return Objects.equals(customerService, that.customerService)
                && Objects.equals(credentialsService, that.credentialsService)
                && Objects.equals(credentialsController, that.credentialsController);
    }

    /**
     * hashCode method
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(customerService, credentialsService, credentialsController);
    }

    /**
     * toString method
     * @return String
     */
    @Override
    public String toString() {
        return "CustomerController { " +
                "customerService = " + customerService +
                "credentialsService = " + credentialsService +
                "credentialsController = " + credentialsController +
                " }";
    }
}
