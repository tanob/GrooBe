package com.github.tanob.groobe.hamcrest

import com.github.tanob.groobe.AssertionsLoader
import static org.hamcrest.CoreMatchers.not
import static org.hamcrest.MatcherAssert.assertThat

public class EqualityAssertions implements AssertionsLoader {
    private def shouldBeEqualTo = { assertThat delegate, is(it) }
    private def shouldNotBeEqualTo = { assertThat delegate, is(not(it)) }

    def void load() {
        shouldBeEqual()
        shouldNotBeEqual()
    }

    private def shouldNotBeEqual() {
        Object.metaClass.shouldNotBe = shouldNotBeEqualTo
        Object.metaClass.shouldNotEqual = shouldNotBeEqualTo
        Object.metaClass.shouldNotBeEqual = shouldNotBeEqualTo
        Object.metaClass.shouldNotBeEqualTo = shouldNotBeEqualTo
    }

    private def shouldBeEqual() {
        Object.metaClass.shouldBe = shouldBeEqualTo
        Object.metaClass.shouldEqual = shouldBeEqualTo
        Object.metaClass.shouldBeEqual = shouldBeEqualTo
        Object.metaClass.shouldBeEqualTo = shouldBeEqualTo
    }

    def void unload() {
        Object.metaClass = null
    }

}
