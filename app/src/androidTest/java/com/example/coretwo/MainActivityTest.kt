package com.example.coretwo


import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


//@LargeTest
//@RunWith(AndroidJUnit4::class)
//class MainActivityTest {
//
//    @Rule
//    @JvmField
//    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
//
//    @Test
//    fun mainActivityTest() {
//    }

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
    }
}

//@LargeTest
//@RunWith(AndroidJUnit4::class)
//class MainActivityTest {
//
//    @Rule
//    @JvmField
//    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
//
//    @Test
//    fun mainActivityTest() {
//    }