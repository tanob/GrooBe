package com.github.tanob.groobe

import org.junit.Before
import org.junit.Test

class CollectionAssertionsTest {
    @Before
    public void setUp() {
        GrooBe.activate();
    }

    @Test
    public void testShouldContainWithSimpleElement() {
        def list = [1, 2, 3]
        list.shouldContain 1
    }

    @Test
    public void testShouldContainWithFailureMessage() {
        def list = [1, 2, 3]
        def failureMessage = "4 is missing"
        try {
            list.shouldContain 4, failureMessage
            throw new AssertionError("should have failed because 4 is missing")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test
    public void testListShouldNotContain() {
        def nums = [2, 3, 5]

        nums.shouldNotContain 1
        nums.shouldNotContain 4
    }

    @Test
    public void testListShouldContainASubsetOfItems() {
        def nums = [1, 2, 3]

        nums.shouldContainSubset ([1, 2])
        nums.shouldContainSubset ([])

        /*
           If parentheses are omitted on tbe shouldContainSubset call, the following exception gets thrown:
           groovy.lang.MissingPropertyException:
             Exception evaluating property 'shouldContainSubset' for java.util.ArrayList,
             Reason: groovy.lang.MissingPropertyException:
               No such property: shouldContainSubset for class: java.lang.Integer
         */
    }

    @Test
    public void testListShouldNotContainASubsetOfItems() {
        def nums = [1, 2, 3]

        nums.shouldNotContainSubset ([0, 10])
        nums.shouldNotContainSubset ([1, 4])

        /*
           If parentheses are omitted on the shouldNotContainSubset call, the following exception gets thrown:
           groovy.lang.MissingPropertyException:
             Exception evaluating property 'shouldNotContainSubset' for java.util.ArrayList,
             Reason: groovy.lang.MissingPropertyException:
               No such property: shouldNotContainSubset for class: java.lang.Integer
         */
    }

    @Test
    public void testShouldNotContainWithFailureMessage() {
        def list = [1, 2, 3]
        def failureMessage = "2 is missing"
        try {
            list.shouldNotContain 2, failureMessage
            throw new AssertionError("should have failed because 2 is in the list")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
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

    @Test
    public void testShouldBeEmptyWithFailureMessage() {
        def failureMessage = "list should be empty"
        try {
            [1, 2].shouldBeEmpty failureMessage
            throw new AssertionError("should have failed because list is not empty")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test(expected = AssertionError)
    public void testShouldNotBeEmptyWithEmptyList() {
        def list = []
        list.shouldNotBeEmpty()
    }

    @Test
    public void testShouldNotBeEmptyWithFailureMessage() {
        def failureMessage = "list should not be empty"
        try {
            [].shouldNotBeEmpty failureMessage
            throw new AssertionError("should have failed because list is empty")
        } catch (AssertionError e) {
            e.message.shouldStartWith failureMessage
        }
    }

    @Test
    public void testShouldNotBeEmptyWithNonEmptyList() {
        def list = [1, 2, 3]
        list.shouldNotBeEmpty()
    }

}
