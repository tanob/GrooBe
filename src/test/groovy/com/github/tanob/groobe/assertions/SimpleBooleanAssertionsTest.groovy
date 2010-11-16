package com.github.tanob.groobe.assertions

import com.github.tanob.groobe.AssertionsLoader
import com.github.tanob.groobe.BooleanAssertionsTest

class SimpleBooleanAssertionsTest extends BooleanAssertionsTest {

    AssertionsLoader getAssertionsLoader() {
        BooleanAssertions.getInstance()
    }

    void testAssertionsMissingAfterUnload() {
        super.testAssertionsMissingAfterUnload()

        (TRUE_VALUES + FALSE_VALUES).each { value ->
            shouldFail MissingPropertyException, {
                value.shouldBeTrue
            }

            shouldFail MissingMethodException, {
                value.shouldBeTrue "message"
            }

            shouldFail MissingPropertyException, {
                value.shouldBeFalse
            }

            shouldFail MissingMethodException, {
                value.shouldBeFalse "message"
            }
        }
    }

    void testShouldBeTrue() {
        TRUE_VALUES.each {
            it.shouldBeTrue
        }
    }

    void testShouldBeFalse() {
        FALSE_VALUES.each {
            it.shouldBeFalse
        }
    }

    void testFailedShouldBeTrue() {
        def assertionCallback = {error, customMessage ->
            verifyFailedShouldBe error, customMessage, true

        }

        FALSE_VALUES.each { value ->
            shouldFail null, assertionCallback, {
                value.shouldBeTrue
            }

            shouldFail "shouldBeTrue", assertionCallback, {
                value.shouldBeTrue "shouldBeTrue"
            }
        }
    }

    void testFailedShouldBeFalse() {
        def assertionCallback = {error, customMessage ->
            verifyFailedShouldBe error, customMessage, false
        }

        TRUE_VALUES.each { value ->
            shouldFail null, assertionCallback, {
                value.shouldBeFalse
            }

            shouldFail "shouldBeFalse custom fail message", assertionCallback, {
                value.shouldBeFalse "shouldBeFalse custom fail message"
            }
        }
    }

    @Override
    void verifyFailedShouldBe(Throwable error, String customMessage, boolean expected) {
        String expectedMessage = customMessage ?: "NOT $expected as expected"
        assertEquals expectedMessage, error.message
    }

    @Override
    void verifyFailedShouldNotBe(Throwable error, String customMessage, boolean unexpected) {
        String expectedMessage = customMessage ?: "NOT expecting $unexpected"
        assertEquals expectedMessage, error.message
    }

}
