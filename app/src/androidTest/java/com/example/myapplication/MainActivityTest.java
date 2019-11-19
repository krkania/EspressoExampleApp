package com.example.myapplication;


import android.graphics.Color;
import android.graphics.drawable.Drawable;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.hasBackground;
import static androidx.test.espresso.matcher.ViewMatchers.hasTextColor;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.ViewAction.*;
import static androidx.test.espresso.action.ViewActions.click;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

import org.junit.Assert.*;
public class MainActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void displaysButtonsOnLoad() {
        onView(withId(R.id.dukeBtn)).check(matches(isDisplayed()));
        onView(withId(R.id.uncBtn)).check(matches(isDisplayed()));
        onView(withId(R.id.stateBtn)).check(matches(isDisplayed()));
    }

    @Test
    public void checkTextOnStateClick(){
        onView(withId(R.id.stateBtn)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.statePage)).check(matches(isDisplayed()));
        onView(withId(R.id.stateAnswer)).check(matches(withText("...state who?")));
        onView(withId(R.id.stateAnswer)).check(matches(hasTextColor(R.color.white)));


    }



}