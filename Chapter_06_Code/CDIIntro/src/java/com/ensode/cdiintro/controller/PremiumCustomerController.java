package com.ensode.cdiintro.controller;

import com.ensode.cdiintro.interceptorbinding.LoggingInterceptorBinding;
import com.ensode.cdiintro.model.Customer;
import com.ensode.cdiintro.model.PremiumCustomer;
import com.ensode.cdiintro.qualifier.Premium;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@LoggingInterceptorBinding
@Named
@RequestScoped
public class PremiumCustomerController {

    private static final Logger logger = Logger.getLogger(
            PremiumCustomerController.class.getName());
    @Inject
    @Premium
    private Customer customer;

    public String saveCustomer() {

        PremiumCustomer premiumCustomer = (PremiumCustomer) customer;

        logger.log(Level.INFO, "Saving the following information \n"
                + "{0} {1}, discount code = {2}",
                new Object[]{premiumCustomer.getFirstName(),
                    premiumCustomer.getLastName(),
                    premiumCustomer.getDiscountCode()});

        //If this was a real application, we would have code to save
        //customer data to the database here.

        return "premium_customer_confirmation";
    }
}
