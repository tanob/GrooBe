package com.github.tanob.groobe

import org.codehaus.groovy.runtime.GStringImpl

abstract class StringAssertionsTest extends AssertionsLoaderTest {

    static final String EMPTY_STRING = ""
    static final String[] EMPTY_STRINGS = [EMPTY_STRING, "$EMPTY_STRING"]

    static final String WHITESPACE_STRING = "\r\n\t "
    static final String[] WHITESPACE_STRINGS = [WHITESPACE_STRING, "$WHITESPACE_STRING"]

    static final String TEXT_STRING = " A\n"
    static final String[] TEXT_LENGTH_STRINGS = [TEXT_STRING, "$TEXT_STRING"]

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

            shouldFail MissingMethodException, {
                value.shouldBe EMPTY_STRING
            }

            shouldFail MissingMethodException, {
                value.shouldBeEqualsTo EMPTY_STRING
            }

            shouldFail MissingMethodException, {
                value.shouldBeEqualsToIgnoringCase EMPTY_STRING
            }

            shouldFail MissingMethodException, {
                value.shouldBeIgnoringCase EMPTY_STRING
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
            verifyFailedShouldBeBlank error, customMessage, TEXT_STRING
        }

        TEXT_LENGTH_STRINGS.each { value ->
            shouldFail null, assertionCallback, {
                value.shouldBeBlank
            }

            shouldFail "this should be blank", assertionCallback, {
                value.shouldBeBlank "this should be blank"
            }
        }
    }

    void testShouldNotBeBlank() {
        WHITESPACE_STRINGS.each {
            it.shouldNotBeBlank
        }

        TEXT_LENGTH_STRINGS.each {
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
        TEXT_LENGTH_STRINGS.each {
            it.shouldHaveText
        }
    }

    void testFailedShouldHaveText() {
        def assertionCallback = {error, customMessage ->
            verifyFailedShouldHaveText error, customMessage, WHITESPACE_STRING
        }

        WHITESPACE_STRINGS.each { value ->
            shouldFail null, assertionCallback, {
                value.shouldHaveText
            }

            shouldFail "should have text message", assertionCallback, {
                value.shouldHaveText "should have text message"
            }
        }
    }

    void testShouldBe_shouldBeEqualsTo() {
        EMPTY_STRINGS.each {
            it.shouldBe EMPTY_STRING
            it.shouldBeEqualsTo EMPTY_STRING
        }
    }

    void testFailedShouldBe_shouldBeEqualsTo() {
        def assertionCallback = {error, customMessage ->
            verifyFailedShouldBe error, customMessage, TEXT_STRING, WHITESPACE_STRING
        }

        WHITESPACE_STRINGS.each { value ->
            shouldFail null, assertionCallback, {
                value.shouldBe TEXT_STRING
            }

            shouldFail "should be text message", assertionCallback, {
                value.shouldBe TEXT_STRING, "should be text message"
            }

            shouldFail null, assertionCallback, {
                value.shouldBeEqualsTo TEXT_STRING
            }

            shouldFail "should be equals to text message", assertionCallback, {
                value.shouldBeEqualsTo TEXT_STRING, "should be equals to text message"
            }
        }
    }

    void testShouldBeIgnoringCase_shouldBeEqualsToIgnoringCase() {
        TEXT_LENGTH_STRINGS.each {
            it.shouldBeIgnoringCase TEXT_STRING
            it.shouldBeIgnoringCase TEXT_STRING.toLowerCase()
            it.shouldBeEqualsToIgnoringCase TEXT_STRING
            it.shouldBeEqualsToIgnoringCase TEXT_STRING.toLowerCase()
        }
    }

    void testFailedShouldBeIgnoringCase_shouldBeEqualsToIgnoringCase() {
        def assertionCallback = {error, customMessage ->
            verifyFailedShouldBe error, customMessage, WHITESPACE_STRING, TEXT_STRING
        }

        TEXT_LENGTH_STRINGS.each { value ->
            shouldFail null, assertionCallback, {
                value.shouldBeIgnoringCase WHITESPACE_STRING
            }

            shouldFail "should be ignoring case", assertionCallback, {
                 value.shouldBeIgnoringCase WHITESPACE_STRING, "should be ignoring case"
            }

            shouldFail null, assertionCallback, {
                value.shouldBeEqualsToIgnoringCase WHITESPACE_STRING
            }

            shouldFail "should be equals to ignoring case", assertionCallback, {
                value.shouldBeEqualsToIgnoringCase WHITESPACE_STRING, "should be equals to ignoring case"
            }
        }
    }

    abstract void verifyFailedShouldBeBlank(AssertionError error, String customMessage, String result)

    abstract void verifyFailedShouldNotBeBlank(AssertionError error, String customMessage, String result)

    abstract void verifyFailedShouldHaveText(AssertionError error, String customMessage, String result)

    abstract void verifyFailedShouldBe(AssertionError error, String customMessage, CharSequence expected, CharSequence result)

}
