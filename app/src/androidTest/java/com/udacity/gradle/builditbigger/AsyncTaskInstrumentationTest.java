package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Pair;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.pressBack;
import static org.hamcrest.Matchers.not;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;


/**
 * Created by amit on 03-08-2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AsyncTaskInstrumentationTest {

  //  String result = new EndPointsAsyncTask(this).execute(Pair<Context,String> this, "java");


    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void check_AsyncTask(){
        onView(withId(R.id.joke_button)).
                perform(click());

        pressBack();

        onView(withId(R.id.jokeResult_text)).
                check(matches(not(withText(""))));

    }
    }

