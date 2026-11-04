/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: TestEmailGenerator.java
 * Description: User interaction sequences of the Email Generation application.
 * One customer of each segment is created and the generated emails are checked for personalized, segment-specific text.
 */

package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import edu.bu.met.cs665.customer.BusinessCustomer;
import edu.bu.met.cs665.customer.Customer;
import edu.bu.met.cs665.customer.FrequentCustomer;
import edu.bu.met.cs665.customer.NewCustomer;
import edu.bu.met.cs665.customer.ReturningCustomer;
import edu.bu.met.cs665.customer.VipCustomer;
import edu.bu.met.cs665.email.Email;
import edu.bu.met.cs665.email.EmailTemplate;
import edu.bu.met.cs665.generator.EmailGenerator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

/**
 * Every test uses a fresh generator and at least one customer of the segment under test.
 */
public class TestEmailGenerator {

    private final EmailGenerator generator = new EmailGenerator();

    /**
     * Create one customer of every segment.
     *
     * @return the five customers in a fixed order
     */
    private List<Customer> oneOfEachSegment() {
        return List.of(
                new BusinessCustomer("A", "A@gmail.com"),
                new ReturningCustomer("B", "B@gmail.com"),
                new FrequentCustomer("C", "C@gmail.com"),
                new NewCustomer("D", "D@gmail.com"),
                new VipCustomer("E", "E@gmail.com"));
    }

    /**
     * A business customer gets the business text, addressed to the right person and address.
     */
    @Test
    public void testBusinessCustomerGetsBusinessEmail() {
        Customer a = new BusinessCustomer("A", "A@gmail.com");

        Email email = generator.generate(a);

        assertEquals("A@gmail.com", email.getRecipientAddress());
        assertTrue(email.getBody().startsWith("Dear A,"));
        assertTrue(email.getSubject().contains("business"));
        assertTrue(email.getBody().contains("volume pricing"));
    }

    /**
     * A returning customer is welcomed back by name and gets the comeback code.
     */
    @Test
    public void testReturningCustomerGetsWelcomeBackEmail() {
        Customer b = new ReturningCustomer("B", "B@gmail.com");

        Email email = generator.generate(b);

        assertEquals("B@gmail.com", email.getRecipientAddress());
        assertEquals("Welcome back, B!", email.getSubject());
        assertTrue(email.getBody().contains("WELCOMEBACK10"));
    }

    /**
     * A frequent customer is thanked and gets the loyalty reward.
     */
    @Test
    public void testFrequentCustomerGetsLoyaltyEmail() {
        Customer c = new FrequentCustomer("C", "C@gmail.com");

        Email email = generator.generate(c);

        assertEquals("C@gmail.com", email.getRecipientAddress());
        assertTrue(email.getSubject().contains("loyal"));
        assertTrue(email.getBody().contains("double loyalty points"));
    }

    /**
     * A new customer is welcomed and gets the first-order code.
     */
    @Test
    public void testNewCustomerGetsWelcomeEmail() {
        Customer d = new NewCustomer("D", "D@gmail.com");

        Email email = generator.generate(d);

        assertEquals("D@gmail.com", email.getRecipientAddress());
        assertEquals("Welcome to " + EmailTemplate.COMPANY_NAME + "!", email.getSubject());
        assertTrue(email.getBody().contains("NEW15"));
    }

    /**
     * A VIP customer gets the invitation, addressed by name in the subject.
     */
    @Test
    public void testVipCustomerGetsInvitationEmail() {
        Customer e = new VipCustomer("E", "E@gmail.com");

        Email email = generator.generate(e);

        assertEquals("E@gmail.com", email.getRecipientAddress());
        assertEquals("An exclusive invitation for our VIP member E", email.getSubject());
        assertTrue(email.getBody().contains("pre-sale"));
    }

    /**
     * Five segments, five different subjects and five different bodies.
     */
    @Test
    public void testEachSegmentGetsDifferentText() {
        List<Email> emails = generator.generateAll(oneOfEachSegment());

        Set<String> subjects = new HashSet<>();
        Set<String> bodies = new HashSet<>();
        for (Email email : emails) {
            subjects.add(email.getSubject());
            bodies.add(email.getBody());
        }

        assertEquals(5, emails.size());
        assertEquals(5, subjects.size());
        assertEquals(5, bodies.size());
    }

    /**
     * The base template is shared, every email has the same greeting form and the same closing.
     */
    @Test
    public void testAllEmailsShareTheBaseTemplate() {
        List<Email> emails = generator.generateAll(oneOfEachSegment());

        for (Email email : emails) {
            assertTrue(email.getBody().startsWith("Dear "));
            assertTrue(email.getBody().endsWith("The " + EmailTemplate.COMPANY_NAME + " Team"));
        }
    }

    /**
     * Batch generation returns one email per customer, in the same order as the input.
     */
    @Test
    public void testGenerateAllKeepsOrder() {
        List<Customer> customers = oneOfEachSegment();

        List<Email> emails = generator.generateAll(customers);

        assertEquals(customers.size(), emails.size());
        for (int i = 0; i < customers.size(); i++) {
            assertEquals(customers.get(i).getEmailAddress(), emails.get(i).getRecipientAddress());
        }
    }

    /**
     * A null customer is rejected instead of producing a broken email.
     */
    @Test
    public void testNullCustomerIsRejected() {
        try {
            generator.generate(null);
            fail("Expected an IllegalArgumentException for a null customer");
        } catch (IllegalArgumentException expected) {
            // expected
        }
    }

    /**
     * A customer without a name cannot be created.
     */
    @Test
    public void testBlankNameIsRejected() {
        try {
            new VipCustomer("   ", "E@gmail.com");
            fail("Expected an IllegalArgumentException for a blank name");
        } catch (IllegalArgumentException expected) {
            // expected
        }
    }

}
