package com.github.tanob.groobe.assertions

import org.junit.Test

class BooleanAssertionsTest extends AssertionsLoaderTest {

    def BooleanAssertionsTest() {
        super(new BooleanAssertions())
    }

    void testLoad() {
        // still don't know how to check this correctly
    }

    void testUnload() {
        // still don't know how to check this correctly
    }

    @Test
    void testAssumptions() {
        new Boolean(true).shouldBeTrue
        Boolean.TRUE.shouldBeTrue
        true.shouldBeTrue

        new Boolean(false).shouldBeFalse
        Boolean.FALSE.shouldBeFalse
        false.shouldBeFalse
    }

    @Test
    void testFaultAssumptionsWithoutDescription() {
        shouldFailWithMessage "NOT true as expected", {
            false.shouldBeTrue
        }

        shouldFailWithMessage "NOT false as expected", {
            true.shouldBeFalse
        }
    }

    @Test
    void testFaultAssumptionsWithDescription() {
        shouldFailWithMessage "this should be true", {
            false.shouldBeTrue "this should be true"
        }

        shouldFailWithMessage "this should be false", {
            true.shouldBeFalse "this should be false"
        }
    }

}
