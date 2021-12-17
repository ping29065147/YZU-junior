package com.cornez.tapbuttoncounter;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

import com.robotium.solo.Solo;

import android.app.Activity;
import android.app.Application;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
//import android.test.ApplicationTestCase;
import com.robotium.solo.Solo;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
public class ApplicationTest {
    private static final String NOTE_1 = "Note 1";
    private static final String NOTE_2 = "Note 2";
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);
    private Solo solo;

    @Before
    public void setUp() throws Exception {
        solo = new Solo(InstrumentationRegistry.getInstrumentation(), activityTestRule.getActivity());
    }

    @After
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    @Test
    public void testAddNote() throws Exception
    {
        solo.clickOnView(solo.getView(R.id.button));
        solo.clickOnView(solo.getView(R.id.button));
        solo.clickOnView(solo.getView(R.id.button5));

        boolean notesFound = solo.searchText("31");
        assertTrue("not found", notesFound);
    }

    @Test
    public void testEditNote() throws Exception
    {
        solo.clickOnView(solo.getView(R.id.button2));
        solo.clickOnView(solo.getView(R.id.button2));
        solo.clickOnView(solo.getView(R.id.button2));
        solo.clickOnView(solo.getView(R.id.button5));

        boolean notesFound = solo.searchText("25.9");
        assertTrue("not found", notesFound);
    }
}

/*public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
}*/