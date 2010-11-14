package com.github.tanob.groobe.assertions

import com.github.tanob.groobe.AssertionsLoader
import com.github.tanob.groobe.NumberAssertionsTest

class SimpleNumberAssertionsTest extends NumberAssertionsTest {

    AssertionsLoader getAssertionsLoader() {
        NumberAssertions.getInstance()
    }

    void verifyFailedEquality(AssertionError error, String customMessage, Number expected, Number result) {
        String expectedMessage = customMessage ?: "expecting ${expected}, not ${result}"
        assertEquals expectedMessage, error.message
    }

}
