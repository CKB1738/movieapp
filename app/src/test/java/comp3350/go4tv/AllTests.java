package comp3350.go4tv;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.go4tv.Persistence.MoviePersistenceTest;
import comp3350.go4tv.Persistence.UserPersistenceTest;
import comp3350.go4tv.application.ServiceTest;
import comp3350.go4tv.business.AccessMovieTest;
import comp3350.go4tv.business.AccessUserTest;
import comp3350.go4tv.business.EmailValidatorTest;
import comp3350.go4tv.business.FieldValidatorTest;
import comp3350.go4tv.object.CommentTest;
import comp3350.go4tv.object.MovieTest;
import comp3350.go4tv.object.UserTest;
import comp3350.go4tv.persistence.UserPersistence;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                UserTest.class,
                MovieTest.class,
                CommentTest.class,
                UserPersistenceTest.class,
                MoviePersistenceTest.class,
                EmailValidatorTest.class,
                FieldValidatorTest.class,
                AccessUserTest.class,
                AccessMovieTest.class,
                ServiceTest.class
        }
)



public class AllTests {


}
