package com.github.tanob.groobe.assertions

import org.junit.Test

class NumberAssertionsTest extends AssertionsLoaderTest {

    def NumberAssertionsTest() {
        super(new NumberAssertions())
    }

    void testLoad() {
        // still don't know how to check this correctly
    }

    void testUnload() {
        // still don't know how to check this correctly
    }

    @Test
    void testEquality() {
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
    void testFaultyEqualityWithoutDescription() {
        shouldFailAndDisplay "expecting 2, not 1", {
            1.shouldBe 2
        }

        shouldFailAndDisplay "expecting 2, not 1", {
            1.shouldBeEqualsTo 2
        }
    }

    @Test
    void testFaultyEqualityWithDescription() {
        shouldFailAndDisplay "1 == 2", {
            1.shouldBe 2, "1 == 2"
        }

        shouldFailAndDisplay "1 == 2", {
            1.shouldBeEqualsTo 2, "1 == 2"
        }
    }

}
