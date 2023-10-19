package com.example.coretwo

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



//    // Click the "Borrow" button
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
//    .perform(ViewActions.click())
//
//    // Check if the intent to start CarDetailsActivity is fired
//    Intents.intended(IntentMatchers.hasComponent(BorrowCycle::class.java.name))
//
//    // Click the "Save" button (assuming the "Save" button has an ID like R.id.btSave)
//    Espresso.onView(ViewMatchers.withId(R.id.buttonSave))
//    .perform(ViewActions.click())
//
//    // Check if the "Borrow" button is disabled
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
//    // Click the "Borrow" button
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
//    .perform(ViewActions.click())
//
//    // Check if the intent to start CarDetailsActivity is fired
//    Intents.intended(IntentMatchers.hasComponent(BorrowCycle::class.java.name))
//
//    // Click the "Save" button (assuming the "Save" button has an ID like R.id.btSave)
//    Espresso.onView(ViewMatchers.withId(R.id.buttonSave))
//    .perform(ViewActions.click())
//
//    // Check if the "Borrow" button is disabled
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))


@RunWith(AndroidJUnit4::class)
class MainActivityUITest {
    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        // Initialize Espresso-Intents for testing intents
        Intents.init()
    }

    @After
    fun tearDown() {
        // Release Espresso-Intents resources
        Intents.release()
    }



    //    // Click the "Borrow" button
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
//    .perform(ViewActions.click())
//
//    // Check if the intent to start CarDetailsActivity is fired
//    Intents.intended(IntentMatchers.hasComponent(BorrowCycle::class.java.name))
//
//    // Click the "Save" button (assuming the "Save" button has an ID like R.id.btSave)
//    Espresso.onView(ViewMatchers.withId(R.id.buttonSave))
//    .perform(ViewActions.click())
//
//    // Check if the "Borrow" button is disabled
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))


    @Test
    fun testNextButton() {
        // Launch the activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // Find the TextView element that displays the cycle name by its ID
        Espresso.onView(ViewMatchers.withId(R.id.nameOfCycle))

            // Check if the TextView initially displays 'Toyota'
            .check(matches(ViewMatchers.withText("Cycle1")))

        // Perform an action to trigger the change
        Espresso.onView(ViewMatchers.withText("Next"))
            .perform(ViewActions.click())

        // Check if the TextView now displays 'Nissan'
        Espresso.onView(ViewMatchers.withId(R.id.nameOfCycle))
            .check(matches(ViewMatchers.withText("Cycle2")))

        activityScenario.close()
    }

    //    // Click the "Borrow" button
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
//    .perform(ViewActions.click())
//
//    // Check if the intent to start CarDetailsActivity is fired
//    Intents.intended(IntentMatchers.hasComponent(BorrowCycle::class.java.name))
//
//    // Click the "Save" button (assuming the "Save" button has an ID like R.id.btSave)
//    Espresso.onView(ViewMatchers.withId(R.id.buttonSave))
//    .perform(ViewActions.click())
//
//    // Check if the "Borrow" button is disabled
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))



    @Test
    fun testPageLoop() {
        // Launch the activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // Find the TextView element that displays the cycle name by its ID
        Espresso.onView(ViewMatchers.withId(R.id.nameOfCycle))

            // Check if the TextView initially displays 'Toyota'
            .check(matches(ViewMatchers.withText("Cycle1")))

        for (i in 1..3) {
            // Perform an action to trigger the change
            Espresso.onView(ViewMatchers.withText("Next"))
                .perform(ViewActions.click())

            // Wait for a moment to ensure the UI update
            Thread.sleep(1000)
        }
        // Check if the TextView displays the same cycle
        Espresso.onView(ViewMatchers.withId(R.id.nameOfCycle))
            .check(matches(ViewMatchers.withText("Cycle1")))

        activityScenario.close()
    }


    //    // Click the "Borrow" button
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
//    .perform(ViewActions.click())
//
//    // Check if the intent to start CarDetailsActivity is fired
//    Intents.intended(IntentMatchers.hasComponent(BorrowCycle::class.java.name))
//
//    // Click the "Save" button (assuming the "Save" button has an ID like R.id.btSave)
//    Espresso.onView(ViewMatchers.withId(R.id.buttonSave))
//    .perform(ViewActions.click())
//
//    // Check if the "Borrow" button is disabled
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))


    @Test
    fun testBorrowButton() {
        // Click the "Borrow" button
        Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
            .perform(ViewActions.click())

        // Check if the intent to start cycleDetailsActivity is fired
        Intents.intended(IntentMatchers.hasComponent(BorrowCycle::class.java.name))
    }

    //    // Click the "Borrow" button
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
//    .perform(ViewActions.click())
//
//    // Check if the intent to start CarDetailsActivity is fired
//    Intents.intended(IntentMatchers.hasComponent(BorrowCycle::class.java.name))
//
//    // Click the "Save" button (assuming the "Save" button has an ID like R.id.btSave)
//    Espresso.onView(ViewMatchers.withId(R.id.buttonSave))
//    .perform(ViewActions.click())
//
//    // Check if the "Borrow" button is disabled
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))



    @Test
    fun testNoPosterInCycleDetails() {
        // Click the "Borrow" button
        Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
            .perform(ViewActions.click())

        // Check if the intent to start CycleDetailsActivity is fired
        Intents.intended(IntentMatchers.hasComponent(BorrowCycle::class.java.name))

        // Check if the ivPoster ImageView is nonexistent (not visible)
        Espresso.onView(ViewMatchers.withId(R.id.cycleImage))
            .check(ViewAssertions.doesNotExist())
    }


    //    // Click the "Borrow" button
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
//    .perform(ViewActions.click())
//
//    // Check if the intent to start CarDetailsActivity is fired
//    Intents.intended(IntentMatchers.hasComponent(BorrowCycle::class.java.name))
//
//    // Click the "Save" button (assuming the "Save" button has an ID like R.id.btSave)
//    Espresso.onView(ViewMatchers.withId(R.id.buttonSave))
//    .perform(ViewActions.click())
//
//    // Check if the "Borrow" button is disabled
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))


    @Test
    fun testReturnBackAfterRent() {
        // Click the "Borrow" button
        Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
            .perform(ViewActions.click())

        // Check if the intent to start CycleBorrow is fired
        Intents.intended(IntentMatchers.hasComponent(BorrowCycle::class.java.name))

        // Click the "Save" button (assuming the "Save" button has an ID like R.id.buttontSave)
        Espresso.onView(ViewMatchers.withId(R.id.buttonSave))
            .perform(ViewActions.click())

        // Check if the "cycleName" TextView stays the same
        Espresso.onView(ViewMatchers.withId(R.id.nameOfCycle))
            .check(matches(ViewMatchers.withText("Cycle1")))
    }


    //    // Click the "Borrow" button
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
//    .perform(ViewActions.click())
//
//    // Check if the intent to start CarDetailsActivity is fired
//    Intents.intended(IntentMatchers.hasComponent(BorrowCycle::class.java.name))
//
//    // Click the "Save" button (assuming the "Save" button has an ID like R.id.btSave)
//    Espresso.onView(ViewMatchers.withId(R.id.buttonSave))
//    .perform(ViewActions.click())
//
//    // Check if the "Borrow" button is disabled
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))


    fun testCantBorrowTwice() {
        // Click the "Borrow" button
        Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
            .perform(ViewActions.click())

        // Check if the intent to start CycleDetailsActivity is fired
        Intents.intended(IntentMatchers.hasComponent(BorrowCycle::class.java.name))

        // Click the "Save" button (assuming the "Save" button has an ID like R.id.btSave)
        Espresso.onView(ViewMatchers.withId(R.id.buttonSave))
            .perform(ViewActions.click())

        // Check if the "Borrow" button is disabled
        Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
            .check(matches(Matchers.not(isEnabled())))
    }


    //    // Click the "Borrow" button
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
//    .perform(ViewActions.click())
//
//    // Check if the intent to start CarDetailsActivity is fired
//    Intents.intended(IntentMatchers.hasComponent(BorrowCycle::class.java.name))
//
//    // Click the "Save" button (assuming the "Save" button has an ID like R.id.btSave)
//    Espresso.onView(ViewMatchers.withId(R.id.buttonSave))
//    .perform(ViewActions.click())
//
//    // Check if the "Borrow" button is disabled
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))


    @Test
    fun testRentCancel() {
        // Click the "Borrow" button
        Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
            .perform(ViewActions.click())

        // Press the back button
        Espresso.pressBack()

        // Check if the "Borrow" button is enabled
        Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
            .check(matches(isEnabled()))
    }


//    // Click the "Borrow" button
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
//    .perform(ViewActions.click())
//
//    // Check if the intent to start CarDetailsActivity is fired
//    Intents.intended(IntentMatchers.hasComponent(BorrowCycle::class.java.name))
//
//    // Click the "Save" button (assuming the "Save" button has an ID like R.id.btSave)
//    Espresso.onView(ViewMatchers.withId(R.id.buttonSave))
//    .perform(ViewActions.click())
//
//    // Check if the "Borrow" button is disabled
//    Espresso.onView(ViewMatchers.withId(R.id.buttonBorrow))
//    .check(matches(Matchers.not(isEnabled())))
}