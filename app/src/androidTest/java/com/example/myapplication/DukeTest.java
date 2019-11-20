package com.example.myapplication;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasTextColor;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DukeTest {

//    @Before
//    public void registerIdlingResource() {
//        // let espresso know to synchronize with background tasks
//        IdlingRegistry.getInstance().register(EspressoIdlingResource.getIdlingResource());
//    }
//
//    @After
//    public void unregisterIdlingResource() {
//        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getIdlingResource());
//    }


    @Rule
    public ActivityTestRule<Duke> activityTestRule = new ActivityTestRule<>(Duke.class);

























    //    @Test
//    public void stateButtonClick(){
//        onView(withId(R.id.stateBtn)).check(matches(isDisplayed())).perform(click());
//        //check that correct activity (page) is loaded
//        onView(withId(R.id.statePage)).check(matches(isDisplayed()));
//        //check textcontent
//        onView(withId(R.id.stateAnswer)).check(matches(withText("...state who?")));
//        //check textcolor
//        onView(withId(R.id.stateAnswer)).check(matches(hasTextColor(R.color.white)));
//    }


























//    @Test
//    public void UncButtonClick() {
//        onView(withId(R.id.uncBtn)).check(matches(isDisplayed())).perform(click());
//        onView(withId(R.id.uncPage)).check(matches(isDisplayed()));
//        onView(withId(R.id.UNCanswer)).check(matches(withText("YES!")));
//        onView(withId(R.id.UNCanswer)).check(matches(hasTextColor(R.color.black)));
//
//    }


}