package com.github.tanob.groobe.assertions

import org.junit.Test

class StringAssertionsTest extends AssertionsLoaderTest {

    def emptyString = ""
    def whitespaceString = "\r\n\t "
    def textString = " A "

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
    void testEmptyStrings() {
        "".shouldBeEmpty
        "".shouldHaveLength 0
    }

    @Test
    void testFaultyEmptyStringsWithoutDescription() {
        shouldFailWithMessage "EMPTY String expected, not 'A'", {
            "A".shouldBeEmpty
        }

        shouldFailWithMessage "length=0 expected, not 1", {
            " ".shouldHaveLength 0
        }
    }

    @Test
    void testFaultyEmptyStringsWithDescription() {
        shouldFailWithMessage "this should be empty", {
            "A".shouldBeEmpty "this should be empty"
        }

        shouldFailWithMessage "this should have no length", {
            " ".shouldHaveLength 0, "this should have no length"
        }
    }

    @Test
    void testNonEmptyStrings() {
        " ".shouldHaveLength
        "  1 ".shouldHaveLength 4
        "\r\n\t 1".shouldHaveText
    }

    @Test
    void testFaultyNonEmptyStringsWithoutDescription() {
        shouldFailWithMessage "NOT expecting an empty String", {
            "".shouldHaveLength
        }

        shouldFailWithMessage "length=1 expected, not 2", {
            "  ".shouldHaveLength 1
        }

        shouldFailWithMessage "String with text content expected", {
            "\r\n\t ".shouldHaveText
        }
    }

    @Test
    void testFaultyNonEmptyStringsWithDescription() {
        shouldFailWithMessage "this should have length", {
            "".shouldHaveLength "this should have length"
        }

        shouldFailWithMessage "this should have length 1", {
            "  ".shouldHaveLength 1, "this should have length 1"
        }

        shouldFailWithMessage "this should have text", {
            "\r\n\t ".shouldHaveText "this should have text"
        }
    }

}
