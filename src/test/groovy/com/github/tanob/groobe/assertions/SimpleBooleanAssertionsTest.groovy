package com.github.tanob.groobe.assertions

import com.github.tanob.groobe.AssertionsLoader
import com.github.tanob.groobe.BooleanAssertionsTest
import static org.junit.Assert.assertEquals

class SimpleBooleanAssertionsTest extends BooleanAssertionsTest {

    AssertionsLoader getAssertionsLoader() {
        return new BooleanAssertions()
    }

    @Override
    void verifyFailedShouldBeTrue(AssertionError e, String customMessage) {
        String expectedMessage = customMessage ?: "NOT true as expected"
        assertEquals expectedMessage, e.message
    }

    @Override
    void verifyFailedShouldBeFalse(AssertionError e, String customMessage) {
        String expectedMessage = customMessage ?: "NOT false as expected"
        assertEquals expectedMessage, e.message
    }

}
