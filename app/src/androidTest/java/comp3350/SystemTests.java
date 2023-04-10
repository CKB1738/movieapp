package comp3350;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.go4tv.FavouritesTest;
import comp3350.go4tv.MoviesTest;
import comp3350.go4tv.ProfileTest;
import comp3350.go4tv.SignUpTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        FavouritesTest.class,
        MoviesTest.class,
        ProfileTest.class,
        SignUpTest.class
})
public class SystemTests {
}