/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: VipCustomer.java
 * Description: A VIP customer. Pairs itself with VipEmailTemplate.
 */

package edu.bu.met.cs665.customer;

import edu.bu.met.cs665.email.EmailTemplate;
import edu.bu.met.cs665.email.VipEmailTemplate;

/**
 * Concrete Creator: the VIP segment.
 * Its factory method pairs this segment with the invitation template.
 */
public class VipCustomer extends Customer {

    /**
     * Create a VIP customer.
     *
     * @param name the customer's name
     * @param emailAddress the customer's email address
     */
    public VipCustomer(String name, String emailAddress) {
        super(name, emailAddress);
    }

    /** VIP customers receive the invitation template. */
    @Override
    public EmailTemplate createEmailTemplate() {
        return new VipEmailTemplate();
    }

}
