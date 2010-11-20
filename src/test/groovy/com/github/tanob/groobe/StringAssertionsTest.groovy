package com.github.tanob.groobe

import java.nio.CharBuffer
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

    @Test
    public void testShouldStartWithAssertionWithFailureMessage() {
        def failureMessage = "string does not start with 'this'"
        try {
            "string".shouldStartWith "this", failureMessage
            throw new AssertionError("should have failed because 'string' does not start with 'this'")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test(expected = AssertionError)
    public void testAStringShouldNotStartWith() {
        "some string".shouldNotStartWith "some"
    }

    @Test
    public void testShouldNotStartWithAssertionWithFailureMessage() {
        def failureMessage = "string starts with 'str'"
        try {
            "string".shouldNotStartWith "str", failureMessage
            throw new AssertionError("should have failed because 'string' starts with 'str'")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test
    public void testAStringShouldEndWith() {
        "this is a string".shouldEndWith "string"
    }

    @Test
    public void testShouldEndWithAssertionWithFailureMessage() {
        def failureMessage = "'string' does not end with 'something'"
        try {
            "string".shouldEndWith "something", failureMessage
            throw new AssertionError("should have failed because 'string' does not end with 'something'")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test(expected = AssertionError)
    public void testAStringShouldNotEndWith() {
        "some string".shouldNotEndWith "string"
    }

    @Test
    public void testShouldNotEndWithAssertionWithFailureMessage() {
        def failureMessage = "'string' does end with 'ing'"
        try {
            "string".shouldNotEndWith "ing", failureMessage
            throw new AssertionError("should have failed because 'string' does end with 'ing'")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test
    public void testStringShouldContain() {
        "a string contains".shouldContain "string"
    }

    @Test
    public void testShouldContainWithFailureMessage() {
        def failureMessage = "contains does not contain 'string'"
        try {
            "contains".shouldContain "string", failureMessage
            throw new AssertionError("should have failed because 'contains' does not contain 'string'")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test
    public void testStringShouldNotContain() {
        "a different string".shouldNotContain "the same string"
    }

    @Test
    public void testShouldNotContainWithFailureMessage() {
        def failureMessage = "'string' contains 'ing'"
        try {
            "string".shouldNotContain "ing", failureMessage
            throw new AssertionError("should have failed because 'string' contains 'ing'")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test
    public void testShouldBeEmptyWithEmptyString() {
        "".shouldBeEmpty()
    }

    @Test(expected = AssertionError)
    public void testShouldBeEmptyWithNonEmptyString() {
        "non empty string".shouldBeEmpty()
    }

    @Test
    public void testShouldBeEmptyWithFailureMessage() {
        def failureMessage = "string is not empty"
        try {
            "non empty string".shouldBeEmpty failureMessage
            throw new AssertionError("should have failed because the string is not empty")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test
    public void testShouldNotBeEmptyWithNonEmptyString() {
        "non empty string".shouldNotBeEmpty()
    }

    @Test
    public void testShouldNotBeEmptyWithFailureMessage() {
        def failureMessage = "string is empty"
        try {
            "".shouldNotBeEmpty failureMessage
            throw new AssertionError("should have failed because the string is empty")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test(expected = AssertionError)
    public void testShouldNotBeEmptyWithEmptyString() {
        "".shouldNotBeEmpty()
    }

    @Test
    public void testShouldStartWithAssertionWithStringBuilder() {
        def stringBuilder = new StringBuilder("a string inside the builder")
        stringBuilder.shouldStartWith "a string"
    }

    @Test
    public void testShouldNotStartWithAssertionWithCharBuffer() {
        def charBuffer = CharBuffer.wrap("a char sequence")
        charBuffer.shouldNotStartWith "a string"
    }

    @Test
    public void testShouldNotStartWithAssertionWithStringBuffer() {
        def stringBuffer = new StringBuffer("string buffer")
        stringBuffer.shouldNotStartWith "buffer"
    }

    @Test
    public void testShouldEndWithAssertionWithStringBuffer() {
        def stringBuffer = new StringBuffer("string buffer")
        stringBuffer.shouldEndWith "buffer"
    }

    @Test
    public void testShouldNotEndWithAssertionWithStringBuilder() {
        def stringBuilder = new StringBuilder("string builder")
        stringBuilder.shouldNotEndWith "buffer"
    }

    @Test
    public void testShouldContainWithStringBuffer() {
        def stringBuffer = new StringBuffer("string buffer")
        stringBuffer.shouldContain "ff"
    }

    @Test
    public void testShouldNotContainWithCharBuffer() {
        def charBuffer = CharBuffer.wrap("char buffer")
        charBuffer.shouldNotContain "builder"
    }

    @Test
    public void testShouldStartWithAssertionWithCharBufferAndStringBuilder() {
        def charBuffer = CharBuffer.wrap("char buffer")
        def stringBuilder = new StringBuilder("char")
        charBuffer.shouldStartWith stringBuilder
    }

    @Test
    public void testShouldNotStartWithAssertionWithStringBuilderAndStringBuffer() {
        def stringBuilder = new StringBuilder("builder")
        def stringBuffer = new StringBuffer("buffer")
        stringBuilder.shouldNotStartWith stringBuffer
    }

    @Test
    public void testShouldEndWithAssertionWithStringBuilderAndCharBuffer() {
        def charBuffer = CharBuffer.wrap("char buffer")
        def stringBuilder = new StringBuilder("ffer")
        charBuffer.shouldEndWith stringBuilder
    }

    @Test
    public void testShouldNotEndWithAssertionWithStringBuilderAndCharBuffer() {
        def stringBuilder = new StringBuilder("builder")
        def charBuffer = CharBuffer.wrap("buffer")
        stringBuilder.shouldNotEndWith charBuffer
    }

    @Test
    public void testShouldContainWithStringBufferAndCharBuffer() {
        def stringBuffer = new StringBuffer("string buffer")
        def charBuffer = CharBuffer.wrap("buffer")
        stringBuffer.shouldContain charBuffer
    }

    @Test
    public void testShouldNotContainWithStringBuilderAndStringBuffer() {
        def stringBuilder = new StringBuilder("builder")
        def stringBuffer = new StringBuffer("buffer")
        stringBuilder.shouldNotContain stringBuffer
    }

    @Test
    public void testShouldBeEmptyWithCharBuffer() {
        CharBuffer.wrap("").shouldBeEmpty()
    }

    @Test
    public void testShouldNotBeEmptyWithStringBuilder() {
        new StringBuilder("string").shouldNotBeEmpty()
    }
}
