/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: BusinessEmailTemplate.java
 * Description: The email sent to business customers: supply, invoicing and bulk shipment.
 */


package edu.bu.met.cs665.email;

/**
 * Concrete Product: the email for the Business segment.
 * Business customers usually buy in volume, so the text is about supply, invoicing and bulk orders.
 */
public class BusinessEmailTemplate extends EmailTemplate {

    /** Subject for business customers. */
    @Override
    protected String subject(Recipient recipient) {
        return "Partner with " + COMPANY_NAME + " for your business supplies";
    }

    /** Introduction for business customers. */
    @Override
    protected String introduction(Recipient recipient) {
        return "Thank you for choosing " + COMPANY_NAME + " as a supplier for your business. Your business account includes volume pricing, one consolidated monthly invoice and a dedicated account representative.";
    }

    /** Offer for business customers. */
    @Override
    protected String offer(Recipient recipient) {
        return "This month, every bulk order over $500 ships for free. Reply to this email to schedule a call with your representative";
    }

}
