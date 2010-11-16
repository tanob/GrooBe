package com.github.tanob.groobe

abstract class BooleanAssertionsTest extends AssertionsLoaderTest {

    static final TRUE_VALUES = [new Boolean(true), Boolean.TRUE, true]
    static final FALSE_VALUES = [new Boolean(false), Boolean.FALSE, false]

    void testOtherAssertionsShouldRemainAvailableAfterUnload() {
        Boolean.metaClass.beforeUnload = { "beforeUnload" }
        assertionsLoader.unload()
        assertEquals "beforeUnload", true.beforeUnload()
    }

    void testAssertionsMissingAfterUnload() {
        assertionsLoader.unload()

        (TRUE_VALUES + FALSE_VALUES).each { value ->
            shouldFail MissingMethodException, {
                value.shouldBe true
            }

            shouldFail MissingMethodException, {
                value.shouldBeEqualsTo true
            }

            shouldFail MissingMethodException, {
                value.shouldNotBe false
            }

            shouldFail MissingMethodException, {
                value.shouldNotBeEqualsTo false
            }
        }
    }

    void testShouldBeTrue_shouldNotBeFalse() {
        TRUE_VALUES.each {
            it.shouldBe true
            it.shouldBeEqualsTo true
            it.shouldNotBe false
            it.shouldNotBeEqualsTo false
        }
    }

    void testShouldBeFalse_shouldNotBeTrue() {
        FALSE_VALUES.each {
            it.shouldBe false
            it.shouldBeEqualsTo false
            it.shouldNotBe true
            it.shouldNotBeEqualsTo true
        }
    }

    void testFailedShouldBeTrue() {
        def assertionCallback = {error, customMessage ->
            verifyFailedShouldBe error, customMessage, true
        }

        FALSE_VALUES.each { value ->
            shouldFail null, assertionCallback, {
                value.shouldBe true
            }

            shouldFail null, assertionCallback, {
                value.shouldBeEqualsTo true
            }

            shouldFail "shouldBe", assertionCallback, {
                value.shouldBe true, "shouldBe"
            }

            shouldFail "shouldBeEqualsTo", assertionCallback, {
                value.shouldBeEqualsTo true, "shouldBeEqualsTo"
            }
        }
    }

    void testFailedShouldNotBeTrue() {
        def assertionCallback = {error, customMessage ->
            verifyFailedShouldNotBe error, customMessage, true
        }

        TRUE_VALUES.each { value ->
            shouldFail null, assertionCallback, {
                value.shouldNotBe true
            }

            shouldFail null, assertionCallback, {
                value.shouldNotBeEqualsTo true
            }

            shouldFail "shouldNotBe", assertionCallback, {
                value.shouldNotBe true, "shouldNotBe"
            }

            shouldFail "shouldNotBeEqualsTo", assertionCallback, {
                value.shouldNotBeEqualsTo true, "shouldNotBeEqualsTo"
            }
        }
    }

    void testFailedShouldBeFalse() {
        def assertionCallback = {error, customMessage ->
            verifyFailedShouldBe error, customMessage, false
        }

        TRUE_VALUES.each { value ->
            shouldFail null, assertionCallback, {
                value.shouldBe false
            }

            shouldFail null, assertionCallback, {
                value.shouldBeEqualsTo false
            }

            shouldFail "shouldBe", assertionCallback, {
                value.shouldBe false, "shouldBe"
            }

            shouldFail "shouldBeEqualsTo", assertionCallback, {
                value.shouldBeEqualsTo false, "shouldBeEqualsTo"
            }
        }
    }

    void testFailedShouldNotBeFalse() {
        def assertionCallback = {error, customMessage ->
            verifyFailedShouldNotBe error, customMessage, false
        }

        FALSE_VALUES.each { value ->
            shouldFail null, assertionCallback, {
                value.shouldNotBe false
            }

            shouldFail null, assertionCallback, {
                value.shouldNotBeEqualsTo false
            }

            shouldFail "shouldNotBe", assertionCallback, {
                value.shouldNotBe false, "shouldNotBe"
            }

            shouldFail "shouldNotBeEqualsTo", assertionCallback, {
                value.shouldNotBeEqualsTo false, "shouldNotBeEqualsTo"
            }
        }
    }

    void verifyFailedShouldBe(Throwable error, String customMessage, boolean expected) {
        fail "not yet implemented"
    }

    void verifyFailedShouldNotBe(Throwable error, String customMessage, boolean unexpected) {
        fail "not yet implemented"
    }

}
