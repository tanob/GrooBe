package com.github.tanob.groobe.assertions

import com.github.tanob.groobe.AssertionsLoader
import com.github.tanob.groobe.StringAssertionsTest

class SimpleCharSequenceAssertionsTest extends StringAssertionsTest {

    AssertionsLoader getAssertionsLoader() {
        CharSequenceAssertions.getInstance()
    }

    void verifyFailedShouldBeBlank(AssertionError error, String customMessage, String result) {
        String expectedMessage = customMessage ?: "BLANK String expected, not '${result}'"
        assertEquals expectedMessage, error.message
    }

    void verifyFailedShouldNotBeBlank(AssertionError error, String customMessage, String result) {
        String expectedMessage = customMessage ?: "NOT expecting a blank String"
        assertEquals expectedMessage, error.message
    }

    void verifyFailedShouldHaveText(AssertionError error, String customMessage, String result) {
        String expectedMessage = customMessage ?: "String with visible text content expected"
        assertEquals expectedMessage, error.message
    }

    void verifyFailedShouldBe(AssertionError error, String customMessage, CharSequence expected, CharSequence result) {
        String expectedMessage = customMessage ?: "Strings are not equal: expecting '$expected', not '$result'"
        assertEquals expectedMessage, error.message
    }

}
