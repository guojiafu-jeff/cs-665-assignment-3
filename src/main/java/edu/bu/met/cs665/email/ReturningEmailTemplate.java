/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: ReturningEmailTemplate.java
 * Description: The email sent to returning customers: welcome back plus a comeback discount.
 */

package edu.bu.met.cs665.email;

/**
 * Concrete Product: the email for the Returning segment.
 * A returning customer has not ordered for a while, so the email welcomes them back.
 */
public class ReturningEmailTemplate extends EmailTemplate {

    /** Subject for returning customers, personalized with the name. */
    @Override
    protected String subject(Recipient recipient) {
        return "Welcome back, " + recipient.getName() + "!";
    }

    /** Introduction for returning customers. */
    @Override
    protected String introduction(Recipient recipient) {
        return "It has been a while since your last order, and we are glad to see you again. Since your last visit we have added hundreds of new products and faster delivery options.";
    }

    /** Offer for returning customers. */
    @Override
    protected String offer(Recipient recipient) {
        return "Use the code WELCOMEBACK10 at checkout for 10% off your next order. The code is valid for 30 days.";
    }

}
