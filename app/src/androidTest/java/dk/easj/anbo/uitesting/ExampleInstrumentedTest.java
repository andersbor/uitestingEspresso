package dk.easj.anbo.uitesting;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    // https://developer.android.com/training/testing/espresso/setup
    @Test
    public void testItAll() {
        onView(withText("Hello World!")).check(matches(isDisplayed()));

        onView(withId(R.id.mainCountButton)).perform(ViewActions.click());
        onView(withId(R.id.mainResultTextView)).check(matches(withText("1")));

        onView(withId(R.id.mainCountButton)).perform(ViewActions.click());
        onView(withId(R.id.mainResultTextView)).check(matches(withText("2")));

        onView(withId(R.id.mainNextButton)).perform(ViewActions.click()); // triggers Intent
        onView(withText("Another")).check(matches(isDisplayed()));

        onView(withId(R.id.anotherTextView)).check((matches(withText("Another"))));

        pressBack(); // press the back button
        onView(withText("2")).check(matches(isDisplayed()));
    }
}
