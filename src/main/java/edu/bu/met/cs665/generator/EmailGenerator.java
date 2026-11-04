/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: EmailGenerator.java
 * Description: Entry point of the Email Generation application.
 * Asks each customer for its template (the factory method) and lets the template compose the email.
 */

package edu.bu.met.cs665.generator;

import edu.bu.met.cs665.customer.Customer;
import edu.bu.met.cs665.email.Email;
import edu.bu.met.cs665.email.EmailTemplate;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The entry point of the application and the Client of the Factory Method pattern.
 *
 * The generator never names a concrete customer or template class.
 * It asks the customer for its template and asks the template to compose the email.
 * Adding a new customer segment does not change this class.
 */
public class EmailGenerator {
    private static final Logger LOGGER = LogManager.getLogger(EmailGenerator.class);

    /**
     * Generate the personalized email for one customer.
     * The template receives the customer only as a Recipient, so the email package never depends on the customer package.
     * Dependencies run generator -> customer -> email.
     *
     * @param customer the customer to write to
     * @return the finished email
     * @throws IllegalArgumentException if customer is null
     */
    public Email generate(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer is required.");
        }
        EmailTemplate template = customer.createEmailTemplate();    // factory method call: the customer picks its template
        Email email = template.compose(customer);   // passed as a Recipient, so email never depends on customer
        LOGGER.info("Generated \"" + email.getSubject() + "\" for " + customer);
        return email;
    }

    /**
     * Generate one email per customer, in the given order.
     *
     * @param customers the customers to write to
     * @return the emails, one per customer, in the same order
     * @throws IllegalArgumentException if the list or any customer in it is null
     */
    public List<Email> generateAll(List<Customer> customers) {
        if (customers == null) {
            throw new IllegalArgumentException("Customer list is required.");
        }
        List<Email> emails = new ArrayList<>();
        for (Customer customer : customers) {
            emails.add(generate(customer));
        }
        return emails;
    }

}


