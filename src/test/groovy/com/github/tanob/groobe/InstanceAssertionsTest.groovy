package com.github.tanob.groobe

import org.junit.Before
import org.junit.Test

class InstanceAssertionsTest {
    @Before
    public void setUp() {
        GrooBe.activate()
    }

    @Test
    public void testShouldBeInstanceOf() {
        "string".shouldBeA String
        1.shouldBeAn Integer
    }

    @Test(expected = AssertionError)
    public void testWhenShouldBeInstanceOfFails() {
        "string".shouldBeAn Integer
    }

    @Test
    public void testShouldNotBeInstanceOf() {
        1.shouldNotBeA String
        "5".shouldNotBeAn Integer
    }

    @Test
    public void testShouldBeInstanceOfWithFailureMessage() {
        def failureMessage = "an integer is not a string"
        try {
            1.shouldBeA String, failureMessage
            throw new AssertionError("should have failed because an integer is not a string")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test
    public void testShouldNotBeInstanceOfWithFailureMessage() {
        def failureMessage = "an integer is an integer"
        try {
            1.shouldNotBeAn Integer, failureMessage
            throw new AssertionError("should have failed because an integer is an integer")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }
}
