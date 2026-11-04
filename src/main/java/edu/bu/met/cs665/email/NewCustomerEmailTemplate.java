/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: NewCustomerEmailTemplate.java
 * Description: The email sent to new customers: a welcome and a first-order discount.
 */


package edu.bu.met.cs665.email;

/**
 * Concrete Product: the email for the New segment.
 * A new customer has just created an account, so the email explains what they can do next.
 */
public class NewCustomerEmailTemplate extends EmailTemplate {

    /** Subject for new customers. */
    @Override
    protected String subject(Recipient recipient) {
        return "Welcome to " + COMPANY_NAME + "!";
    }

    /** Introduction for new customers. */
    @Override
    protected String introduction(Recipient recipient) {
        return "Thank you for creating your account. From your account page you can track orders, save favorites and manage your delivery addresses.";
    }

    /** Offer for new customers. */
    @Override
    protected String offer(Recipient recipient) {
        return "Enjoy 15% off your first order with the code NEW15.";
    }

}
