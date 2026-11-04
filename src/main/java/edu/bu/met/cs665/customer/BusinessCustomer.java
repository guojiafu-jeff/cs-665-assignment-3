/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: BusinessCustomer.java
 * Description: A customer that buys for a business. Pairs itself with BusinessEmailTemplate.
 */

package edu.bu.met.cs665.customer;

import edu.bu.met.cs665.email.BusinessEmailTemplate;
import edu.bu.met.cs665.email.EmailTemplate;

/**
 * Concrete Creator: the Business segment.
 * Its factory method pairs this segment with the business email template.
 */
public class BusinessCustomer extends Customer {

    /**
     * Create a business customer.
     *
     * @param name the contact person's name
     * @param emailAddress the contact person's email address
     */
    public BusinessCustomer(String name, String emailAddress) {
        super(name, emailAddress);
    }

    /** Business customers receive the business template. */
    @Override
    public EmailTemplate createEmailTemplate() {
        return new BusinessEmailTemplate();
    }

}
