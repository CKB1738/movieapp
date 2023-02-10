package comp3350.go4tv.business;

import junit.framework.TestCase;

import org.junit.Test;

import javax.xml.validation.Validator;

import comp3350.go4tv.business.validator.FieldValidator;

public class FieldValidatorTest extends TestCase {

    FieldValidator fieldString;

    @Test
    public void testEmptyField(){
        System.out.println("Testing fieldValidator for empty field");
        fieldString = new FieldValidator("");
        assertFalse(fieldString.isValid());
    }

    @Test
    public void testNonEmptyField() {
        System.out.println("Testing fieldValidator for nonEmpty field");
        fieldString = new FieldValidator("Hello");
        assertTrue(fieldString.isValid());
    }

}