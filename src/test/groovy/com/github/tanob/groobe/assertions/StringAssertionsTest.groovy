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

        def emptyString = ""
        "${emptyString}".shouldBeEmpty
        "${emptyString}".shouldHaveLength 0
    }

    @Test
    void testFaultyEmptynessWithoutDescription() {
        shouldFailWithMessage "EMPTY String expected, not 'A'", {
            "A".shouldBeEmpty
        }

        shouldFailWithMessage "length=0 expected, not 1", {
            " ".shouldHaveLength 0
        }

        shouldFailWithMessage "String with text content expected", {
            "".shouldHaveText
        }

        shouldFailWithMessage "String with text content expected", {
            "\r\n\t   ".shouldHaveText
        }
    }

    @Test
    void testFaultyEmptynessWithDescription() {
        shouldFailWithMessage "this should be empty", {
            "A".shouldBeEmpty "this should be empty"
        }

        shouldFailWithMessage "this should have length", {
            " ".shouldHaveLength 0, "this should have length"
        }

        shouldFailWithMessage "this should have text", {
            "".shouldHaveText "this should have text"
        }

        shouldFailWithMessage "Only with whitespace chars", {
            "\r\n\t   ".shouldHaveText "Only with whitespace chars"
        }
    }

    @Test
    void testNonEmptyString() {
        " ".shouldHaveLength
        "${1}".shouldHaveLength
        " ".shouldHaveLength 1
        " 1 ".shouldHaveLength 3
        "${1.class}".shouldHaveText
        "  1 ".shouldHaveText
    }

    @Test
    void testFaultyNonEmptyStringWithoutDescription() {
        shouldFailWithMessage "length=1 expected, not 0", {
            "".shouldHaveLength 1
        }
    }

    @Test
    void testFaultyNonEmptyStringWithDescription() {
        shouldFailWithMessage "this should have 1 single char", {
            "".shouldHaveLength 1, "this should have 1 single char"
        }
    }

}
