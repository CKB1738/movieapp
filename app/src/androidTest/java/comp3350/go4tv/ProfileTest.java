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
public class ProfileTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule= new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void signIn(){

        // log in
        onView(withId(R.id.signInUsername)).perform(typeText("Xin"));
        onView(withId(R.id.signInPassword)).perform(typeText("abc123"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.signInButton)).perform(click());

        // click the profile button
        onView(withId(R.id.profileButton)).perform(click());

        // profile page
        onView(withId(R.id.profileUsername)).check(matches(withText("Xin")));
        onView(withId(R.id.profileEmail)).check(matches(withText("umnie2@myumanitoba.ca")));
        onView(withId(R.id.profilePassword)).check(matches(withText("abc123")));
    }
}
