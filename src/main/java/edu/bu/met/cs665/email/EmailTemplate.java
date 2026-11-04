/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: EmailTemplate.java
 * Description: The base email template: a fixed skeleton (greeting, introduction, offer, closing)
 * with the segment-specific parts left to subclasses. Product of the Factory Method pattern.
 */

package edu.bu.met.cs665.email;

/**
 * The base email template and the Product of the Factory Method pattern.
 *
 * compose() is the skeleton shared by every email.
 * The parts that differ per customer segment (subject, introduction, offer) are abstract methods that each concrete template fills in.
 * The greeting and the closing have one default implementation that all segments share, so they are written exactly once.
 */
public abstract class EmailTemplate {
    /** The company that sends the emails. Used in the closing and in some subject lines. */
    public static final String COMPANY_NAME = "Jeff Inc";

    /**
     * Compose a complete email for one recipient.
     * The method is final so that no template can change the shared structure, only the content of its own sections.
     *
     * @param recipient who the email is for
     * @return the finished email
     * @throws IllegalArgumentException if recipient is null
     */
    public final Email compose(Recipient recipient) {
        if (recipient == null) {
            throw new IllegalArgumentException("Recipient is required.");
        }
        String body = greeting(recipient) + "\n\n"
                + introduction(recipient) + "\n\n"
                + offer(recipient) + "\n\n"
                + closing();
        return new Email(recipient.getEmailAddress(), subject(recipient), body);
    }

    /**
     * The subject line. Different for every customer segment.
     *
     * @param recipient who the email is for
     * @return the subject line
     */
    protected abstract String subject(Recipient recipient);

    /**
     * Introduction.
     *
     * @param recipient who the email is for
     * @return the introduction paragraph
     */
    protected abstract String introduction(Recipient recipient);

    /**
     * The paragraph with the offer made to this customer segment.
     *
     * @param recipient who the email is for
     * @return the offer paragraph
     */
    protected abstract String offer(Recipient recipient);

    /**
     * The greeting line, the same for all segments. A subclass may override it.
     *
     * @param recipient who the email is for
     * @return the greeting line
     */
    protected String greeting(Recipient recipient) {
        return "Dear " + recipient.getName() + ",";
    }

    /**
     * The sign-off, the same for all segments. A subclass may override it.
     *
     * @return the closing lines
     */
    protected String closing() {
        return "Best regards,\nThe " + COMPANY_NAME + " Team";
    }

}
