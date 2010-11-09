package com.github.tanob.groobe.assertions

import org.junit.Test

class StringAssertionsTest extends AssertionsLoaderTest {

    def StringAssertionsTest() {
        super(new StringAssertions())
    }

    void testLoad() {
        // still don't know how to check this correctly
    }

    void testUnload() {
        // still don't know how to check this correctly
    }

    @Test
    void testEmptyness() {
        "".shouldBeEmpty
        "".shouldHaveLength 0
    }

    @Test
    void testFaultyEmptynessWithoutDescription() {
        shouldFailAndDisplay "EMPTY String expected, not 'A'", {
            "A".shouldBeEmpty
        }

        shouldFailAndDisplay "length=0 expected, not 1", {
            " ".shouldHaveLength 0
        }

        shouldFailAndDisplay "String with text content expected", {
            "".shouldHaveText
        }

        shouldFailAndDisplay "String with text content expected", {
            "\r\n\t   ".shouldHaveText
        }
    }

    @Test
    void testFaultyEmptynessWithDescription() {
        shouldFailAndDisplay "this should be empty", {
            "A".shouldBeEmpty "this should be empty"
        }

        shouldFailAndDisplay "this should have length", {
            " ".shouldHaveLength 0, "this should have length"
        }

        shouldFailAndDisplay "this should have text", {
            "".shouldHaveText "this should have text"
        }

        shouldFailAndDisplay "Only with whitespace chars", {
            "\r\n\t   ".shouldHaveText "Only with whitespace chars"
        }
    }

    @Test
    void testNonEmptyString() {
        " ".shouldHaveLength
        " ".shouldHaveLength 1
        " 1 ".shouldHaveLength 3
        "${1.class}".shouldHaveText
        "  1 ".shouldHaveText
    }

    @Test
    void testFaultyNonEmptyStringWithoutDescription() {
        shouldFailAndDisplay "length=1 expected, not 0", {
            "".shouldHaveLength 1
        }
    }

    @Test
    void testFaultyNonEmptyStringWithDescription() {
        shouldFailAndDisplay "this should have 1 single char", {
            "".shouldHaveLength 1, "this should have 1 single char"
        }
    }

}
