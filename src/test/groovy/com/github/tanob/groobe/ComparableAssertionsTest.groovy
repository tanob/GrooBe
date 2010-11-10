package com.github.tanob.groobe

import org.junit.Before
import org.junit.Test

class ComparableAssertionsTest {
    @Before
    public void setUp() {
        GrooBe.activate();
    }

    @Test
    public void testANumberIsGreaterThanAnother() {
        2.shouldBeGreaterThan 0
        3.1d.shouldBeGreaterThan 3d
    }

    @Test
    public void testANumberIsLessThanAnother() {
        3.shouldBeLessThan 5
    }

    @Test
    public void testAStringIsGreaterThanAnother() {
        "abc".shouldBeGreaterThan "abb"
    }

    @Test
    public void testAStringIsLessThanAnother() {
        "abb".shouldBeLessThan "abc"
    }
}
