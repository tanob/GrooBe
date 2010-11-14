package com.github.tanob.groobe

import org.junit.Before
import org.junit.Test

class MapAssertionsTest {
    @Before
    public void setUp() {
        GrooBe.activate()
    }

    @Test
    public void testMapShouldHave() {
        def map = [x: 5, y: 6]

        map.shouldHaveKey "y"
        map.shouldHaveValue 6
        map.shouldHaveEntry "x", 5
    }

    @Test
    public void testShouldHaveKeyWithFailureMessage() {
        def failureMessage = "the map does not have y"
        try {
            [x: 3].shouldHaveKey "y", failureMessage
            throw new AssertionError("should have failed because y is not a key in map")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test
    public void testShouldHaveValueWithFailureMessage() {
        def failureMessage = "the map does not have value 4"
        try {
            [x: 3].shouldHaveValue 4, failureMessage
            throw new AssertionError("should have failed because 4 is not a value in map")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test
    public void testShouldHaveEntryWithFailureMessage() {
        def failureMessage = "the map does not have an entry x: 3"
        try {
            [y: 4].shouldHaveEntry "x", 3, failureMessage
            throw new AssertionError("should have failed because x: 3 is not an entry in the map")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test
    public void testMapShouldNotHaveKey() {
        def map = [x: 5]

        map.shouldNotHaveKey "y"
    }

    @Test
    public void testShouldNotHaveKeyWithFailureMessage() {
        def failureMessage = "the map has a key x"
        try {
            [x: 42].shouldNotHaveKey "x", failureMessage
            throw new AssertionError("should have failed because x is a key in the map")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test
    public void testMapShouldNotHaveValue() {
        def map = [x: 5]

        map.shouldNotHaveValue 4
    }

    @Test
    public void testShouldNotHaveValueWithFailureMessage() {
        def failureMessage = "the map has a value 42"
        try {
            [x: 42].shouldNotHaveValue 42, failureMessage
            throw new AssertionError("should have failed because 42 is a value in the map")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test
    public void testMapShouldNotHaveEntry() {
        def map = [x: 5]

        map.shouldNotHaveEntry "y", 5
    }

    @Test
    public void testShouldNotHaveEntryWithFailureMessage() {
        def failureMessage = "the map does have an entry y: 4"
        try {
            [y: 4, x: 7].shouldNotHaveEntry "y", 4, failureMessage
            throw new AssertionError("should have failed because y: 4 is an entry in the map")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }
}
