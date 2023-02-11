package comp3350.go4tv;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.go4tv.application.ServiceTest;
import comp3350.go4tv.business.AccessUserTest;
import comp3350.go4tv.business.EmailValidatorTest;
import comp3350.go4tv.business.FieldValidatorTest;
import comp3350.go4tv.object.CommentTest;
import comp3350.go4tv.object.MovieTest;
import comp3350.go4tv.object.UserTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                UserTest.class,
                MovieTest.class,
                CommentTest.class,

                EmailValidatorTest.class,
                FieldValidatorTest.class,
                AccessUserTest.class,
                ServiceTest.class
        }
)



public class AllTests {


}
