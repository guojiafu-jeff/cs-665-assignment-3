/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: NewCustomer.java
 * Description: A customer who just created an account. Pairs itself with NewCustomerEmailTemplate.
 */

package edu.bu.met.cs665.customer;

import edu.bu.met.cs665.email.EmailTemplate;
import edu.bu.met.cs665.email.NewCustomerEmailTemplate;

/**
 * Concrete Creator: the New segment.
 * Its factory method pairs this segment with the welcome template.
 */
public class NewCustomer extends Customer {

    /**
     * Create a new customer.
     *
     * @param name the customer's name
     * @param emailAddress the customer's email address
     */
    public NewCustomer(String name, String emailAddress) {
        super(name, emailAddress);
    }

    /** New customers receive the welcome template. */
    @Override
    public EmailTemplate createEmailTemplate() {
        return new NewCustomerEmailTemplate();
    }

}
