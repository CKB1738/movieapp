package comp3350.go4tv;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

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
public class SignUpTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule= new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void signIn(){
        // go to signUp page
        onView(withId(R.id.signUpButton)).perform(click());

        // enter the info for the new user
        onView(withId(R.id.signUpUsername)).perform(typeText("TestUser1"));
        onView(withId(R.id.signUpEmail)).perform(typeText("testuser@email.com"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.signUpPassword)).perform(typeText("testuser123"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.signUpButton)).perform(click());

        // sign in with the new user
        onView(withId(R.id.signInUsername)).perform(typeText("TestUser1"));
        onView(withId(R.id.signInPassword)).perform(typeText("testuser123"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.signInButton)).perform(click());
    }
}
