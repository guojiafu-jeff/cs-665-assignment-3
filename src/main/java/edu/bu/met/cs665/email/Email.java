/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: Email.java
 * Description: A finished email: recipient address, subject line and body text. Immutable.
 */

package edu.bu.met.cs665.email;

/**
 * A finished email produced by an EmailTemplate.
 * Objects of this class are immutable, so once composed, an email cannot be changed.
 * Thus it can be passed around and logged safely.
 */
public final class Email {
    private final String recipientAddress;
    private final String subject;
    private final String body;

    /**
     * Create an email. Only EmailTemplate.compose() needs to call this.
     *
     * @param recipientAddress the address the email is sent to
     * @param subject the subject line
     * @param body the full text of the email
     * @throws IllegalArgumentException if any argument is null
     */
    public Email(String recipientAddress, String subject, String body) {
        if ((recipientAddress == null) || (subject == null) || (body == null)) {
            throw new IllegalArgumentException("Recipient address, subject and body are required.");
        }
        this.recipientAddress = recipientAddress;
        this.subject = subject;
        this.body = body;
    }

    /**
     * Get the address the email is sent to.
     *
     * @return the recipient's email address
     */
    public String getRecipientAddress() {
        return recipientAddress;
    }

    /**
     * Get the subject line.
     *
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Get the full text of the email.
     *
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Render the email the way a mail client would show it.
     * Used by Main for logging.
     *
     * @return "To:" line, "Subject:" line, a blank line, then the body
     */
    @Override
    public String toString() {
        return "To: " + recipientAddress + "\nSubject: " + subject + "\n\n" + body;
    }

}
