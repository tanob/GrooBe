package com.github.tanob.groobe

import org.junit.Before
import org.junit.Test

class ComparableAssertionsTest {
    @Before
    public void setUp() {
        GrooBe.activate();
    }

    @Test
    public void testANumberIsGreaterThanAnother() {
        2.shouldBeGreaterThan 0
        3.1d.shouldBeGreaterThan 3d
    }

    @Test
    public void testANumberIsGreaterThanWithFailureMessage() {
        def failureMessage = "learn math: 5 > 4 > 3 > 2 -> 5 > 2"
        try {
            2.shouldBeGreaterThan 5, failureMessage
            throw new AssertionError("should have failed because 5 > 2")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test
    public void testANumberIsLessThanAnother() {
        3.shouldBeLessThan 5
    }

    @Test
    public void testANumberIsLessThanAnotherWithFailureMessage() {
        def failureMessage = "learn math: 5 = 5"
        try {
            5.shouldBeLessThan 5, failureMessage
            throw new AssertionError("should have failed because 5 = 5")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test
    public void testAStringIsGreaterThanAnother() {
        "abc".shouldBeGreaterThan "abb"
    }

    @Test
    public void testAStringIsLessThanAnother() {
        "abb".shouldBeLessThan "abc"
    }
}
