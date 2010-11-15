package com.github.tanob.groobe

import org.codehaus.groovy.runtime.GStringImpl

abstract class StringAssertionsTest extends AssertionsLoaderTest {

    static final String EMPTY_STRING = ""
    static final String[] EMPTY_STRINGS = [EMPTY_STRING, "$EMPTY_STRING"]

    static final String WHITESPACE_LENGTH_4_STRING = "\r\n\t "
    static final String[] WHITESPACE_LENGTH_4_STRINGS = [WHITESPACE_LENGTH_4_STRING, "$WHITESPACE_LENGTH_4_STRING"]

    static final String TEXT_LENGTH_3_STRING = " A\n"
    static final String[] TEXT_LENGTH_3_STRINGS = [TEXT_LENGTH_3_STRING, "$TEXT_LENGTH_3_STRING"]

    void testOtherAssertionsShouldRemainAvailableAfterUnload() {
        [String, GStringImpl].each {
            it.metaClass.someMethod = {
                true
            }
        }

        assertionsLoader.unload()

        assertTrue "".someMethod()
        assertTrue "${this.class}".someMethod()
    }

    void testAssertionsMissingAfterUnload() {
        assertionsLoader.unload()

        EMPTY_STRINGS.each {value ->
            shouldFail MissingPropertyException, {
                value.shouldBeBlank
            }

            shouldFail MissingPropertyException, {
                value.shouldNotBeBlank
            }

            shouldFail MissingPropertyException, {
                value.shouldHaveText
            }
        }
    }

    void testShouldBeBlank() {
        EMPTY_STRINGS.each {
            it.shouldBeBlank
        }

    }

    void testFailedShouldBeBlank() {
        def assertionCallback = {error, customMessage ->
            verifyFailedShouldBeBlank error, customMessage, TEXT_LENGTH_3_STRING
        }

        TEXT_LENGTH_3_STRINGS.each { value ->
            shouldFail null, assertionCallback, {
                value.shouldBeBlank
            }

            shouldFail "this should be blank", assertionCallback, {
                value.shouldBeBlank "this should be blank"
            }
        }
    }

    void testShouldNotBeBlank() {
        WHITESPACE_LENGTH_4_STRINGS.each {
            it.shouldNotBeBlank
        }

        TEXT_LENGTH_3_STRINGS.each {
            it.shouldNotBeBlank
        }
    }

    void testFailedShouldNotBeBlank() {
        def assertionCallback = {error, customMessage ->
            verifyFailedShouldNotBeBlank error, customMessage, EMPTY_STRING
        }

        EMPTY_STRINGS.each {value ->
            shouldFail null, assertionCallback, {
                value.shouldNotBeBlank
            }

            shouldFail "should not be blank message", assertionCallback, {
                value.shouldNotBeBlank "should not be blank message"
            }
        }
    }

    void testShouldHaveText() {
        TEXT_LENGTH_3_STRINGS.each {
            it.shouldHaveText
        }
    }

    void testFailedShouldHaveText() {
        def assertionCallback = {error, customMessage ->
            verifyFailedShouldHaveText error, customMessage, WHITESPACE_LENGTH_4_STRING
        }

        WHITESPACE_LENGTH_4_STRINGS.each { value ->
            shouldFail null, assertionCallback, {
                value.shouldHaveText
            }

            shouldFail "should have text message", assertionCallback, {
                value.shouldHaveText "should have text message"
            }
        }
    }

    abstract void verifyFailedShouldBeBlank(AssertionError error, String customMessage, String result)

    abstract void verifyFailedShouldNotBeBlank(AssertionError error, String customMessage, String result)

    abstract void verifyFailedShouldHaveText(AssertionError error, String customMessage, String result)

}
