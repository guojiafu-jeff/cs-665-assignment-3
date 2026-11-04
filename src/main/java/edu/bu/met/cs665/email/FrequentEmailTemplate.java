/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: FrequentEmailTemplate.java
 * Description: The email sent to frequent customers: a thank-you and a loyalty reward.
 */

package edu.bu.met.cs665.email;

/**
 * Concrete Product: the email for the Frequent segment.
 * Frequent customers order often, so the email thanks them and rewards loyalty.
 */
public class FrequentEmailTemplate extends EmailTemplate {

    /** Subject for frequent customers. */
    @Override
    protected String subject(Recipient recipient) {
        return "A thank-you for being one of our most loyal customers";
    }

    /** Introduction for frequent customers. */
    @Override
    protected String introduction(Recipient recipient) {
        return "You are one of our most frequent shoppers, and every one of your orders means a lot to us.";
    }

    /** Offer for frequent customers. */
    @Override
    protected String offer(Recipient recipient) {
        return "As a thank-you, you earn double loyalty points on every purchase this month. Your points never expire.";
    }

}
