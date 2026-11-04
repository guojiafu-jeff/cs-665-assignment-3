/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: VipEmailTemplate.java
 * Description: The email sent to VIP customers: exclusive benefits and a private pre-sale.
 */

package edu.bu.met.cs665.email;

/**
 * Concrete Product: the email for the VIP segment.
 * VIP customers get the most exclusive treatment, so the email is an invitation.
 */
public class VipEmailTemplate extends EmailTemplate {

    /** Subject for VIP customers, personalized with the name. */
    @Override
    protected String subject(Recipient recipient) {
        return "An exclusive invitation for our VIP member " + recipient.getName();
    }

    /** Introduction for VIP customers. */
    @Override
    protected String introduction(Recipient recipient) {
        return "As a VIP member you enjoy priority customer support, free express shipping and early access to every new collection.";
    }

    /** Offer for VIP customers. */
    @Override
    protected String offer(Recipient recipient) {
        return "You are invited to our private pre-sale this weekend: 25% off everything, before it opens to the public.";
    }
}
