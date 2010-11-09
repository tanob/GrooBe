package com.github.tanob.groobe

import org.hamcrest.Matcher
import static org.hamcrest.CoreMatchers.instanceOf
import static org.hamcrest.CoreMatchers.not
import static org.hamcrest.Matchers.*
import static org.hamcrest.MatcherAssert.assertThat

/**
 */
abstract class GrooBe {
    private static def shouldBeEqualTo = { assertThat delegate, is(it) }
    private static def shouldNotBeEqualTo = { assertThat delegate, is(not(it)) }
    private static def shouldBeInstanceOf = { assertThat delegate, instanceOf(it) }
    private static def shouldNotBeInstanceOf = { assertThat delegate, is(not(instanceOf(it))) }

    public static void activate() {
        equalityAssertions()
        orderingAssertions()
        stringAssertions()
        mapAssertions()
        collectionAssertions()
    }

    private static def equalityAssertions() {
        shouldBeEqual()
        shouldBeInstanceOf()
        shouldNotBeEqual()
        shouldNotBeInstanceOf()
    }

    private static def collectionAssertions() {
        Collection.metaClass.shouldContain = { Object[] args -> assertThat delegate, hasItems(args) }
        Collection.metaClass.shouldNotContain = { Object[] args -> assertThat delegate, notContainAnyOf(args) }
    }

    private static def mapAssertions() {
        Map.metaClass.shouldHaveKey = { assertThat delegate, hasKey(it) }
        Map.metaClass.shouldHaveValue = { assertThat delegate, hasValue(it) }
        Map.metaClass.shouldHaveEntry = { key, value -> assertThat delegate, hasEntry(key, value) }

        Map.metaClass.shouldNotHaveKey = { assertThat delegate, not(hasKey(it)) }
        Map.metaClass.shouldNotHaveValue = { assertThat delegate, not(hasValue(it)) }
        Map.metaClass.shouldNotHaveEntry = { key, value -> assertThat delegate, not(hasEntry(key, value)) }
    }

    private static def stringAssertions() {
        String.metaClass.shouldStartWith = { assertThat delegate, startsWith(it) }
        String.metaClass.shouldNotStartWith = { assertThat delegate, not(startsWith(it)) }

        String.metaClass.shouldEndWith = { assertThat delegate, endsWith(it) }
        String.metaClass.shouldNotEndWith = { assertThat delegate, not(endsWith(it)) }

        String.metaClass.shouldContain = { assertThat delegate, containsString(it) }
        String.metaClass.shouldNotContain = { assertThat delegate, not(containsString(it)) }
    }

    private static def orderingAssertions() {
        Number.metaClass.shouldBeGreaterThan = { assertThat delegate, greaterThan(it) }
        Number.metaClass.shouldBeLessThan = { assertThat delegate, lessThan(it) }
    }

    private static def shouldNotBeInstanceOf() {
        Object.metaClass.shouldNotBeA = shouldNotBeInstanceOf
        Object.metaClass.shouldNotBeAn = shouldNotBeInstanceOf
    }

    private static def shouldBeInstanceOf() {
        Object.metaClass.shouldBeA = shouldBeInstanceOf
        Object.metaClass.shouldBeAn = shouldBeInstanceOf
    }

    private static def shouldNotBeEqual() {
        Object.metaClass.shouldNotBe = shouldNotBeEqualTo
        Object.metaClass.shouldNotEqual = shouldNotBeEqualTo
        Object.metaClass.shouldNotBeEqual = shouldNotBeEqualTo
        Object.metaClass.shouldNotBeEqualTo = shouldNotBeEqualTo
    }

    private static def shouldBeEqual() {
        Object.metaClass.shouldBe = shouldBeEqualTo
        Object.metaClass.shouldEqual = shouldBeEqualTo
        Object.metaClass.shouldBeEqual = shouldBeEqualTo
        Object.metaClass.shouldBeEqualTo = shouldBeEqualTo
    }

    private static Matcher notContainAnyOf(Object[] args) {
        def elems = args.collect { hasItem(it) }
        not(anyOf(elems))
    }
}
