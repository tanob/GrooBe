package com.github.tanob.groobe

import org.junit.Before
import org.junit.Test

class StringAssertionsTest {
    @Before
    public void setUp() {
        GrooBe.activate();
    }

    @Test
    public void testAStringShouldStartWith() {
        "this is a string".shouldStartWith "this"
    }

    @Test(expected = AssertionError)
    public void testAStringShouldNotStartWith() {
        "some string".shouldNotStartWith "some"
    }

    @Test
    public void testAStringShouldEndWith() {
        "this is a string".shouldEndWith "string"
    }

    @Test(expected = AssertionError)
    public void testAStringShouldNotEndWith() {
        "some string".shouldNotEndWith "string"
    }

    @Test
    public void testStringShouldContain() {
        "a string contains".shouldContain "string"
    }

    @Test
    public void testStringShouldNotContain() {
        "a different string".shouldNotContain "the same string"
    }
}
