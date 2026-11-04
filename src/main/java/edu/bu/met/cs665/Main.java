/**
 * Name: JIAFU GUO
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/03/2026
 * File Name: Main.java
 * Description: Console demo of the Email Generation application (the real demonstration is in the JUnit tests).
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.customer.BusinessCustomer;
import edu.bu.met.cs665.customer.Customer;
import edu.bu.met.cs665.customer.FrequentCustomer;
import edu.bu.met.cs665.customer.NewCustomer;
import edu.bu.met.cs665.customer.ReturningCustomer;
import edu.bu.met.cs665.customer.VipCustomer;
import edu.bu.met.cs665.email.Email;
import edu.bu.met.cs665.generator.EmailGenerator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Five customers, one of each segment, and the five different emails generated for them.
 */
public class Main {
  private static final Logger LOGGER = LogManager.getLogger(Main.class);

  /**
   * Run the demo.
   */
  public static void main(String[] args) {
    EmailGenerator generator = new EmailGenerator();
    List<Customer> customers = List.of(
            new BusinessCustomer("A", "A@gmail.com"),
            new ReturningCustomer("B", "B@gmail.com"),
            new FrequentCustomer("C", "C@gmail.com"),
            new NewCustomer("D", "D@gmail.com"),
            new VipCustomer("E", "E@gmail.com"));

    for (Email email : generator.generateAll(customers)) {
      LOGGER.info("\n" + email + "\n");
    }
  }
}
