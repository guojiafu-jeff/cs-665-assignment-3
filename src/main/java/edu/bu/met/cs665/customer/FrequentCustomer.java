/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: FrequentCustomer.java
 * Description: A customer who orders often. Pairs itself with FrequentEmailTemplate.
 */

package edu.bu.met.cs665.customer;

import edu.bu.met.cs665.email.EmailTemplate;
import edu.bu.met.cs665.email.FrequentEmailTemplate;

/**
 * Concrete Creator: the Frequent segment.
 * Its factory method pairs this segment with the loyalty template.
 */
public class FrequentCustomer extends Customer {

    /**
     * Create a frequent customer.
     *
     * @param name the customer's name
     * @param emailAddress the customer's email address
     */
    public FrequentCustomer(String name, String emailAddress) {
        super(name, emailAddress);
    }

    /** Frequent customers receive the loyalty template. */
    @Override
    public EmailTemplate createEmailTemplate() {
        return new FrequentEmailTemplate();
    }

}
