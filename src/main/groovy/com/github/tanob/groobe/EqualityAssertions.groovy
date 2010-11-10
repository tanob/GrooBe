package com.github.tanob.groobe

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.CoreMatchers.*

/**
 */
public class EqualityAssertions {
    private static def shouldBeEqualTo = { assertThat delegate, is(it) }
    private static def shouldNotBeEqualTo = { assertThat delegate, is(not(it)) }

    public static def activate() {
        shouldBeEqual()
        shouldNotBeEqual()
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
}
