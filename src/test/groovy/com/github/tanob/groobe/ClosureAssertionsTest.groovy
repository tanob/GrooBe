package com.github.tanob.groobe

import org.junit.Before
import org.junit.Test

class ClosureAssertionsTest {
    @Before
    public void setUp() {
        GrooBe.activate();
    }

    @Test
    public void testShouldFailWithABlockThatDoesThrowException() {
        { ->
            throw new Exception()
        }.shouldFailWith Exception
    }

    @Test(expected = AssertionError)
    public void testThatShouldFailWithWillOnlyAcceptExactExpectedExceptionClass() {
        {->
            throw new RuntimeException()
        }.shouldFailWith Exception
    }

    @Test(expected = AssertionError)
    public void testThatShouldFailWithWillFailIfNoExceptionIsThrown() {
        { ->
        }.shouldFailWith Exception
    }

    @Test(expected = AssertionError)
    public void testThatShouldFailWithWillAssertExceptionMessageWithExpectedOne() {
        { ->
            throw new RuntimeException("exception message")
        }.shouldFailWith RuntimeException, "a different message"
    }

    @Test
    public void testThatShouldFailWithWillNotFailWithExceptionMessageIsTheEqualToExpectedOne() {
        { ->
            throw new RuntimeException("exception message")
        }.shouldFailWith RuntimeException, "exception message"
    }
}
