package com.github.tanob.groobe

abstract class NumberAssertionsTest extends AssertionsLoaderTest {
    static final ZEROS = [
        new Byte("0"),
        new Short("0"),
        new Integer(0),
        new Float("0.0"),
        new Long(0),
        new Double("0.00"),
        new BigDecimal("0.000"),
        new BigInteger("0000000000")
    ]

    void testOtherAssertionsShouldRemainAvailableAfterUnload() {
        ZEROS.each { value ->
            value.class.metaClass.someMethod = {
                "${value.class.simpleName}Method invoked"
            }
        }

        assertionsLoader.unload()

        ZEROS.each {
            assertEquals "${it.class.simpleName}Method invoked", it.someMethod()            
        }
    }

    void testAssertionsMissingAfterUnload() {
        assertionsLoader.unload()

        ZEROS.each { value ->
            shouldFail MissingMethodException, {
                value.shouldBe 0
            }

            shouldFail MissingMethodException, {
                value.shouldBeEqualsTo 0
            }
        }
    }

    void testEquality() {
        ZEROS.each { left ->
            ZEROS.each { right ->
                left.shouldBeEqualsTo right
                left.shouldBe right
            }
        }
    }

    void testFailedEquality() {
        ZEROS.each { value ->
            Closure assertionCallback = {error, customMessage ->
                verifyFailedEquality error, customMessage, 2, value
            }

            shouldFail null, assertionCallback, {
                value.shouldBe 2
            }

            shouldFail null, assertionCallback, {
                value.shouldBeEqualsTo 2
            }

            shouldFail "0 != 2", assertionCallback, {
                value.shouldBe 2, "0 != 2"
            }

            shouldFail "0 != 2", assertionCallback, {
                value.shouldBeEqualsTo 2, "0 != 2"
            }
        }
    }

    abstract void verifyFailedEquality(AssertionError error, String customMessage, Number expected, Number result)

}
