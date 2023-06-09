package comp3350.go4tv.business;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.go4tv.business.validator.EmailValidator;

public class EmailValidatorTest extends TestCase {



    @Test
    public void testEmptyEmail() {
        System.out.println("\nTesting emailValidator for empty email.\n");
        EmailValidator testEmail = new EmailValidator("");
        assertFalse(testEmail.isValid());
    }

    @Test
    public void testInvalidEmail() {
        System.out.println("\nTesting emailValidator for invalid email.\n");
        EmailValidator testEmail = new EmailValidator("testEmail@emailcom");
        assertFalse(testEmail.isValid());
    }

    @Test
    public void testValidEmail() {
        System.out.println("\nTesting emailValidator with valid email.\n");
        EmailValidator testEmail = new EmailValidator("test@email.com");
        assertTrue(testEmail.isValid());
    }
}