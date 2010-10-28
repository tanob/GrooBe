package com.github.tanob.groobe

import org.junit.Before
import org.junit.Test

class GrooBeTest {
    @Before
    public void setUp() {
        GrooBe.activate();
    }

    @Test
    public void testShouldBe() {
        def x = 5
        x.shouldBe 5
    }

    @Test(expected = AssertionError)
    public void testWhenShouldBeFails() {
        (1+2).shouldBe 4
    }

    @Test
    public void testShouldNotBe() {
        (2*2).shouldNotBe 5
    }

    @Test(expected = AssertionError)
    public void testWhenShouldNotBeFails() {
        (2*2).shouldNotBe 4
    }

    @Test
    public void testShouldEqual() {
        (2+4).shouldEqual 6
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
    public void testAStringShouldStartWith() {
        "this is a string".shouldStartWith "this"
    }

    @Test(expected = AssertionError)
    public void testAStringShouldNotStartWith() {
        "some string".shouldNotStartWith "some"
    }

    @Test
    public void testAStringShouldEndWith() {
        "this is a string".shouldEndWith "string"
    }

    @Test(expected = AssertionError)
    public void testAStringShouldNotEndWith() {
        "some string".shouldNotEndWith "string"
    }

    @Test
    public void testMapShouldHave() {
        def map = new HashMap<String, String>()
        map.put("x", 5)
        map.put("y", 6)

        map.shouldHaveKey "y"
        map.shouldHaveValue 6
        map.shouldHaveEntry "x", 5
    }

    @Test
    public void testMapShouldNotHaveKey() {
        def map = new HashMap<String, String>()
        map.put("x", 5)

        map.shouldNotHaveKey "y"
    }

    @Test
    public void testMapShouldNotHaveValue() {
        def map = new HashMap<String, String>()
        map.put("x", 5)

        map.shouldNotHaveValue 4
    }

    @Test
    public void testMapShouldNotHaveEntry() {
        def map = new HashMap<String, String>()
        map.put("x", 5)

        map.shouldNotHaveEntry "y", 5 
    }

    @Test
    public void testStringShouldContain() {
        "a string contains".shouldContain "string"
    }

    @Test
    public void testStringShouldNotContain() {
        "a different string".shouldNotContain "the same string"
    }

    @Test
    public void testListShouldContain() {
        def nums = new ArrayList<Integer>()
        nums.add(2)
        nums.add(3)
        nums.add(5)

        nums.shouldContain 3, 5
    }

    @Test
    public void testListShouldNotContain() {
        def nums = new ArrayList<Integer>()
        nums.add(2)
        nums.add(3)
        nums.add(5)

        nums.shouldNotContain 1, 4
    }
}
