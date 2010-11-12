package com.github.tanob.groobe.hamcrest

import org.junit.Before
import org.junit.Test
import com.github.tanob.groobe.GrooBe

class InstanceAssertionsTest {
    @Before
    public void setUp() {
        GrooBe.activate()
    }

    @Test
    public void testShouldBeInstanceOf() {
        "string".shouldBeA String
        1.shouldBeAn Integer
    }

    @Test(expected = AssertionError)
    public void testWhenShouldBeInstanceOfFails() {
        "string".shouldBeAn Integer
    }

    @Test
    public void testShouldNotBeInstanceOf() {
        1.shouldNotBeA String
        "5".shouldNotBeAn Integer
    }
}
