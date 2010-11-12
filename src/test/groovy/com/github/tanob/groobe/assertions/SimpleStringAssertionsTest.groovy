package com.github.tanob.groobe.assertions

import com.github.tanob.groobe.AssertionsLoader
import com.github.tanob.groobe.StringAssertionsTest
import static org.junit.Assert.assertEquals

class SimpleStringAssertionsTest extends StringAssertionsTest {

    AssertionsLoader getAssertionsLoader() {
        return new StringAssertions()
    }

    void verifyFailedShouldBeEmpty(AssertionError error, String customMessage, String result) {
        String expectedMessage = customMessage ?: "EMPTY String expected, not '${result}'"
        assertEquals expectedMessage, error.message
    }

    void verifyFailedShouldHaveLength(AssertionError error, String customMessage, String result, int expectedLength) {
        String expectedMessage = customMessage ?:
            expectedLength == -1 ? "NOT expecting an empty String" : "length=${expectedLength} expected, not ${result.length()}"
        
        assertEquals expectedMessage, error.message
    }

    void verifyFailedShouldHaveText(AssertionError error, String customMessage, String result) {
        String expectedMessage = customMessage ?: "String with text content expected"
        assertEquals expectedMessage, error.message
    }
    
}
