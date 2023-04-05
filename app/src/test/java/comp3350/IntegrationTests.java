package comp3350;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.go4tv.business.AccessMovieIT;
import comp3350.go4tv.business.AccessUserIT;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessMovieIT.class,
        AccessUserIT.class
})
public class IntegrationTests {
}
