package com.github.tanob.groobe

import org.junit.Test

abstract class BooleanAssertionsTest extends AssertionsLoaderTest {

    @Test
    final void testShouldBeTrue() {
        new Boolean(true).shouldBeTrue
        Boolean.TRUE.shouldBeTrue
        true.shouldBeTrue
    }

    @Test
    final void testShouldBeFalse() {
        new Boolean(false).shouldBeFalse
        Boolean.FALSE.shouldBeFalse
        false.shouldBeFalse
    }

    @Test
    final void testFailedShouldBeTrue() {
        Closure c = this.&verifyFailedShouldBeTrue

        shouldFail null, c, {
            false.shouldBeTrue
        }

        shouldFail "shouldBeTrue custom fail message", c, {
            false.shouldBeTrue "shouldBeTrue custom fail message"
        }
    }

    @Test
    final void testFailedShouldBeFalse() {
        Closure c = this.&verifyFailedShouldBeFalse

        shouldFail null, c, {
            true.shouldBeFalse
        }

        shouldFail "shouldBeFalse custom fail message", c, {
            true.shouldBeFalse "shouldBeFalse custom fail message"
        }
    }

    abstract void verifyFailedShouldBeTrue(AssertionError e, String customMessage)

    abstract void verifyFailedShouldBeFalse(AssertionError e, String customMessage)

}
