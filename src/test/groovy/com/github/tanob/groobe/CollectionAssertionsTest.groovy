package com.github.tanob.groobe

import org.junit.Before
import org.junit.Test

class CollectionAssertionsTest {
    @Before
    public void setUp() {
        GrooBe.activate();
    }

    @Test
    public void testListShouldContain() {
        def nums = [2, 3, 5]

        nums.shouldContain 3
        nums.shouldContain 5
    }

    @Test
    public void testListShouldNotContain() {
        def nums = [2, 3, 5]

        nums.shouldNotContain 1
        nums.shouldNotContain 4
    }

    @Test
    public void testShouldContainWithSimpleElement() {
        def list = [1, 2, 3]
        list.shouldContain 1
    }

    @Test
    public void testShouldContainWithSublistElement() {
        def listOfLists = [[1, 2], [3, 4], [5, 6, 7]]
        listOfLists.shouldContain([3, 4])

        /*
           Without parenthesis around [3,4] we get an exception:
           groovy.lang.MissingPropertyException: Exception evaluating property 'shouldContain'
           for java.util.ArrayList,
           Reason: groovy.lang.MissingPropertyException: No such property: shouldContain
           for class: java.lang.Integer
        */
    }

    @Test
    public void testShouldBeEmptyWithEmptyList() {
        def list = []
        list.shouldBeEmpty()
    }

    @Test(expected = AssertionError)
    public void testShouldBeEmptyWithNonEmptyList() {
        def list = [1, 2, 3]
        list.shouldBeEmpty()
    }

    @Test(expected = AssertionError)
    public void testShouldNotBeEmptyWithEmptyList() {
        def list = []
        list.shouldNotBeEmpty()
    }

    @Test
    public void testShouldNotBeEmptyWithNonEmptyList() {
        def list = [1, 2, 3]
        list.shouldNotBeEmpty()
    }
}
