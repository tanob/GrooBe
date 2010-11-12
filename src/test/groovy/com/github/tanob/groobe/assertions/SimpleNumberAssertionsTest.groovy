package com.github.tanob.groobe.assertions

import com.github.tanob.groobe.AssertionsLoader
import com.github.tanob.groobe.NumberAssertionsTest
import static org.junit.Assert.assertEquals

class SimpleNumberAssertionsTest extends NumberAssertionsTest {

    AssertionsLoader getAssertionsLoader() {
        return new NumberAssertions()
    }

    void verifyFailedEquality(AssertionError error, String customMessage, Number expected, Number result) {
        String expectedMessage = customMessage ?: "expecting ${expected}, not ${result}"
        assertEquals expectedMessage, error.message
    }

}
