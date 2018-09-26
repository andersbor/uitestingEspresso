package dk.easj.anbo.uitesting;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

   /* @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("dk.easj.anbo.uitesting", appContext.getPackageName());
    }*/

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

        pressBack();
        onView(withText("2")).check(matches(isDisplayed()));
    }
}
