/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: ReturningCustomer.java
 * Description: A customer who came back after a while. Pairs itself with ReturningEmailTemplate.
 */

package edu.bu.met.cs665.customer;

import edu.bu.met.cs665.email.EmailTemplate;
import edu.bu.met.cs665.email.ReturningEmailTemplate;

/**
 * Concrete Creator: the Returning segment.
 * Its factory method pairs this segment with the welcome-back template.
 */
public class ReturningCustomer extends Customer {

    /**
     * Create a returning customer.
     *
     * @param name the customer's name
     * @param emailAddress the customer's email address
     */
    public ReturningCustomer(String name, String emailAddress) {
        super(name, emailAddress);
    }

    /** Returning customers receive the welcome-back template. */
    @Override
    public EmailTemplate createEmailTemplate() {
        return new ReturningEmailTemplate();
    }

}
