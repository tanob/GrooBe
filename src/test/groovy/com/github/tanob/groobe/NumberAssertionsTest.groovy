package com.github.tanob.groobe

import org.junit.Test

abstract class NumberAssertionsTest extends AssertionsLoaderTest {

    @Test
    final void testEquality() {
        def numbers = [
            new Byte("0"),
            new Short("0"),
            new Integer(0),
            new Float("0.0"),
            new Long(0),
            new Double("0.00"),
            new BigDecimal("0.000"),
            new BigInteger("0000000000")
        ]

        numbers.each { Number left ->
            numbers.each { Number right ->
                left.shouldBeEqualsTo right
                left.shouldBe right
            }
        }
    }

    @Test
    final void testFailedEquality() {
        Closure assertionCallback = {AssertionError e, String customMessage ->
            verifyFailedEquality e, customMessage, 2, 1
        }

        shouldFail null, assertionCallback, {
            1.shouldBe 2
        }

        shouldFail null, assertionCallback, {
            1.shouldBeEqualsTo 2
        }

        shouldFail "1 != 2", assertionCallback, {
            1.shouldBe 2, "1 != 2"
        }

        shouldFail "1 != 2", assertionCallback, {
            1.shouldBeEqualsTo 2, "1 != 2"
        }
    }

    abstract void verifyFailedEquality(AssertionError error, String customMessage, Number expected, Number result)

}
