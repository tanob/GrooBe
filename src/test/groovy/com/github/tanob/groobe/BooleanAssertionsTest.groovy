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

            shouldFail MissingPropertyException, {
                value.shouldBeFalse
            }
        }
    }

    void testShouldBeTrue() {
        TRUE_VALUES.each {
            it.shouldBe true
            it.shouldBeEqualsTo true
        }
    }

    void testShouldBeFalse() {
        FALSE_VALUES.each {
            it.shouldBe false
            it.shouldBeEqualsTo false
        }
    }

    void testFailedShouldBeTrue() {
        Closure c = this.&verifyFailedShouldBeTrue

        FALSE_VALUES.each { value ->
            shouldFail null, c, {
                value.shouldBe true
            }

            shouldFail null, c, {
                value.shouldBeEqualsTo true
            }

            shouldFail "shouldBe true custom fail message", c, {
                value.shouldBe true, "shouldBe true custom fail message"
            }

            shouldFail "shouldBeEqualsTo true custom fail message", c, {
                value.shouldBeEqualsTo true, "shouldBeEqualsTo true custom fail message"
            }
        }
    }

    void testFailedShouldBeFalse() {
        Closure c = this.&verifyFailedShouldBeFalse

        TRUE_VALUES.each { value ->
            shouldFail null, c, {
                value.shouldBe false
            }

            shouldFail null, c, {
                value.shouldBeEqualsTo false
            }

            shouldFail "shouldBe false custom fail message", c, {
                value.shouldBe false, "shouldBe false custom fail message"
            }

            shouldFail "shouldBeEqualsTo false custom fail message", c, {
                value.shouldBeEqualsTo false, "shouldBeEqualsTo false custom fail message"
            }
        }
    }

    abstract void verifyFailedShouldBeTrue(Throwable e, String customMessage)

    abstract void verifyFailedShouldBeFalse(Throwable e, String customMessage)

}
