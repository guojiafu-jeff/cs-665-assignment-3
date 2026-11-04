/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: Customer.java
 * Description: Base class of all customer segments.
 * Declares the factory method createEmailTemplate(), so it is the Creator of the Factory Method pattern.
 */

package edu.bu.met.cs665.customer;

import edu.bu.met.cs665.email.EmailTemplate;
import edu.bu.met.cs665.email.Recipient;

/**
 * Base class of all customer segments and the Creator of the Factory Method pattern.
 *
 * Every customer has a name and an email address.
 * A segment decide which email template it receives: the factory method createEmailTemplate().
 */
public abstract class Customer implements Recipient {
    private final String name;
    private final String emailAddress;

    /**
     * Create a customer. Only subclasses call this.
     *
     * @param name the customer's name, used in the greeting
     * @param emailAddress where the customer's emails are sent
     * @throws IllegalArgumentException if either argument is null or blank
     */
    protected Customer(String name, String emailAddress) {
        if ((name == null) || (name.isBlank()) || (emailAddress == null) || (emailAddress.isBlank())) {
            throw new IllegalArgumentException("Name and email address are required.");
        }
        this.name = name;
        this.emailAddress = emailAddress;
    }

    /**
     * Factory method: create the email template that fits this customer segment.
     * Each concrete customer class returns its own EmailTemplate subclass.
     *
     * @return a new template for this segment
     */
    public abstract EmailTemplate createEmailTemplate();

    /**
     * Get the customer's name.
     *
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Get the customer's email address.
     *
     * @return the email address
     */
    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Describe the customer for log messages.
     *
     * @return segment, name and address
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + name + " <" + emailAddress + ">";
    }

}
