package com.github.tanob.groobe

import org.junit.Test

abstract class StringAssertionsTest extends AssertionsLoaderTest {

    @Test
    final void testEmptyStrings() {
        "".shouldBeEmpty
        "".shouldHaveLength 0
    }

    @Test
    final void testFailedEmptyStrings() {
        Closure assertionCallback = {AssertionError e, String customMessage ->
            verifyFailedShouldBeEmpty e, customMessage, "A"
        }

        shouldFail null, assertionCallback, {
            "A".shouldBeEmpty
        }

        shouldFail "this should be empty", assertionCallback, {
            "A".shouldBeEmpty "this should be empty"
        }

        assertionCallback = {AssertionError e, String customMessage ->
            verifyFailedShouldHaveLength e, customMessage, " ", 0
        }

        shouldFail null, assertionCallback, {
            " ".shouldHaveLength 0
        }

        shouldFail "should have length 0", assertionCallback, {
            " ".shouldHaveLength 0, "should have length 0"
        }
    }

    @Test
    final void testNonEmptyStrings() {
        " ".shouldHaveLength
        "  1 ".shouldHaveLength 4
        "\r\n\t 1".shouldHaveText
    }

    @Test
    final void testFailedNonEmptyStrings() {
        Closure assertionCallback = {AssertionError e, String customMessage ->
            verifyFailedShouldHaveLength e, customMessage, "", -1
        }

        shouldFail null, assertionCallback, {
            "".shouldHaveLength
        }

        shouldFail "should have any length", assertionCallback, {
            "".shouldHaveLength "should have any length"
        }

        assertionCallback = {AssertionError e, String customMessage ->
            verifyFailedShouldHaveLength e, customMessage, "  ", 1
        }

        shouldFail null, assertionCallback, {
            "  ".shouldHaveLength 1
        }

        shouldFail "should have length 1", assertionCallback, {
            "  ".shouldHaveLength 1, "should have length 1"
        }

        assertionCallback = {AssertionError e, String customMessage ->
            verifyFailedShouldHaveText e, customMessage, "\r\n\t "
        }

        shouldFail null, assertionCallback, {
            "\r\n\t ".shouldHaveText
        }

        shouldFail "only whitespaces", assertionCallback, {
            "\r\n\t ".shouldHaveText "only whitespaces"
        }
    }

    abstract void verifyFailedShouldBeEmpty(AssertionError error, String customMessage, String result)

    abstract void verifyFailedShouldHaveLength(AssertionError error, String customMessage, String result, int expectedLength)

    abstract void verifyFailedShouldHaveText(AssertionError error, String customMessage, String result)

}
