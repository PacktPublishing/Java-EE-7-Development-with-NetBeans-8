/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensode.cdiintro.controller;

import com.ensode.cdiintro.model.Customer;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author heffel
 */
@Named
@RequestScoped
public class CustomerController {

    @Inject
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String navigateToConfirmation() {
        //Save new customer data to database.

        return "confirmation";
    }
}
