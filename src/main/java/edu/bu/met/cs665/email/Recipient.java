/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: Recipient.java
 * Description: The minimum an email template needs to know about the person who receives the email.
 */

package edu.bu.met.cs665.email;

/**
 * Somebody who can receive an email.
 * The email package depends only on this interface,
 * so a template can be composed for any recipient without knowing the customer classes.
 */
public interface Recipient {
    /**
     * Get the name used in the greeting of the email.
     *
     * @return the recipient's name
     */
    String getName();

    /**
     * Get the address the email is sent to.
     *
     * @return the recipient's email address
     */
    String getEmailAddress();

}