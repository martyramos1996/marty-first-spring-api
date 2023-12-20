package com.marty.first.api.controller;

import com.marty.first.api.entity.Customer;
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

    /**
     * Constructor
     * @param customerService CustomerService
     */
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
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
     * Adds a new customer
     * @param c Customer
     */
    @PostMapping
    public void addCustomer(@RequestBody Customer c) {
        getCustomerService().addCustomer(c);
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
        getCustomerService().deleteCustomerByID(id);
    }

    /**
     *
     * @return CustomerService
     */
    public CustomerService getCustomerService() {
        return customerService;
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
        return Objects.equals(customerService, that.customerService);
    }

    /**
     * hashCode method
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(customerService);
    }

    /**
     * toString method
     * @return String
     */
    @Override
    public String toString() {
        return "CustomerController { " +
                "customerService = " + customerService +
                " }";
    }
}
