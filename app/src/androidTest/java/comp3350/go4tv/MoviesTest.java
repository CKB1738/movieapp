package comp3350.go4tv;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import androidx.test.espresso.Espresso;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.go4tv.presentation.MainActivity;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MoviesTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule= new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void signIn(){
        // log in
        onView(withId(R.id.signInUsername)).perform(typeText("Xin"));
        onView(withId(R.id.signInPassword)).perform(typeText("abc123"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.signInButton)).perform(click());

        // check the main page is displayed correctly
        onView(withId(R.id.movieList1)).check(matches(withText("Knock at the Cabin")));
        onView(withId(R.id.movieList2)).check(matches(withText("Little Dixie")));
        onView(withId(R.id.movieList3)).check(matches(withText("Plane")));
        onView(withId(R.id.movieList4)).check(matches(withText("Puss in Boots: The Last Wish")));
        onView(withId(R.id.movieList5)).check(matches(withText("Black Panther: Wakanda Forever")));

    }
}
