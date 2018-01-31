package com.example.rakesh.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by rakesh on 01/02/18.
 */
@RunWith(AndroidJUnit4.class)
public class LandingActivityTest {

    @Rule
    public ActivityTestRule<LandingActivity> mActivityTestRule = new ActivityTestRule<>(LandingActivity.class);

    @Test
    public void checkIfCartDisplayed() throws Exception {
        onView(withId(R.id.imageView)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfSpinnerDisplayed() throws Exception{
        onView(withId(R.id.state_list)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfCountrySpinnerDisplayed() throws Exception{
        onView(withId(R.id.country_list)).check(matches(isDisplayed()));
    }
}

