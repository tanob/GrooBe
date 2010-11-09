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
        shouldFailAndDisplay "NOT true as expected", {
            false.shouldBeTrue
        }

        shouldFailAndDisplay "NOT false as expected", {
            true.shouldBeFalse
        }
    }

    @Test
    void testFaultAssumptionsWithDescription() {
        shouldFailAndDisplay "this should be false", {
            false.shouldBeTrue "this should be false"
        }

        shouldFailAndDisplay "NOT false as expected", {
            true.shouldBeFalse
        }
    }
}
