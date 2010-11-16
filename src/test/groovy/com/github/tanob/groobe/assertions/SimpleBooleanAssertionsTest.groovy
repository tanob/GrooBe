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
            shouldFail MissingMethodException, {
                value.shouldBe true
            }

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
        super.testShouldBeTrue()

        TRUE_VALUES.each {
            it.shouldBe true
            it.shouldBeTrue
        }
    }

    void testShouldBeFalse() {
        super.testShouldBeFalse()

        FALSE_VALUES.each {
            it.shouldBe false
            it.shouldBeFalse
        }
    }

    void testFailedShouldBeTrue() {
        super.testFailedShouldBeTrue()
        Closure c = this.&verifyFailedShouldBeTrue

        FALSE_VALUES.each { value ->
            shouldFail null, c, {
                value.shouldBe true
            }

            shouldFail null, c, {
                value.shouldBeTrue
            }

            shouldFail "shouldBe true custom fail message", c, {
                value.shouldBe true, "shouldBe true custom fail message"
            }

            shouldFail "shouldBeTrue custom fail message", c, {
                value.shouldBeTrue "shouldBeTrue custom fail message"
            }
        }

    }

    void testFailedShouldBeFalse() {
        super.testFailedShouldBeFalse()
        Closure c = this.&verifyFailedShouldBeFalse

        TRUE_VALUES.each { value ->
            shouldFail null, c, {
                value.shouldBe false
            }

            shouldFail null, c, {
                value.shouldBeFalse
            }

            shouldFail "shouldBe false custom fail message", c, {
                value.shouldBe false, "shouldBe false custom fail message"
            }

            shouldFail "shouldBeFalse custom fail message", c, {
                value.shouldBeFalse "shouldBeFalse custom fail message"
            }
        }
    }

    @Override
    void verifyFailedShouldBeTrue(Throwable e, String customMessage) {
        String expectedMessage = customMessage ?: "NOT true as expected"
        assertEquals expectedMessage, e.message
    }

    @Override
    void verifyFailedShouldBeFalse(Throwable e, String customMessage) {
        String expectedMessage = customMessage ?: "NOT false as expected"
        assertEquals expectedMessage, e.message
    }

}
