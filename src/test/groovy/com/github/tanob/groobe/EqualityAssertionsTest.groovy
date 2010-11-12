package com.github.tanob.groobe

import org.junit.Before
import org.junit.Test
import static org.hamcrest.MatcherAssert.assertThat

class EqualityAssertionsTest {
    @Before
    public void setUp() {
        GrooBe.activate()
    }

    @Test
    public void testShouldBe() {
        def x = 5
        x.shouldBe 5
    }

    @Test(expected = AssertionError)
    public void testWhenShouldBeFails() {
        (1 + 2).shouldBe 4
    }

    @Test
    public void testShouldNotBe() {
        (2 * 2).shouldNotBe 5
    }

    @Test(expected = AssertionError)
    public void testWhenShouldNotBeFails() {
        (2 * 2).shouldNotBe 4
    }

    @Test
    public void testShouldEqual() {
        (2 + 4).shouldEqual 6
    }

    @Test
    public void testShouldNotBeNull() {
        "a string instance".shouldNotBe null
    }

    @Test
    public void testNullCheckWithShouldBe() {
        null.shouldBe null
    }

    @Test(expected = AssertionError)
    public void testNullCheckWithShouldNotBe() {
        null.shouldNotBe null
    }
}
