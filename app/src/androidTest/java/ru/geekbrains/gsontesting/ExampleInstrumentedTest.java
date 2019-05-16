package ru.geekbrains.gsontesting;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void useCase(){
        MainActivity mainActivity = mActivityRule.getActivity();

        onView(withId(R.id.editText))
                .perform(clearText());
        onView(withId(R.id.editText))
                .perform(typeText("Ivan"), closeSoftKeyboard());

        onView(withId(R.id.editText2))
                .perform(clearText());
        onView(withId(R.id.editText2))
                .perform(typeText("Ivanoff"), closeSoftKeyboard());

        onView(withId(R.id.button)).perform(click());

        assertEquals("Ivan", mainActivity.getName());
        onView(withId(R.id.editText))
                .check(matches(withText("Ivan")));

        assertEquals("Ivanoff", mainActivity.getSurname());
        onView(withId(R.id.editText2))
                .check(matches(withText("Ivanoff")));
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("ru.geekbrains.gsontesting", appContext.getPackageName());
    }
}
