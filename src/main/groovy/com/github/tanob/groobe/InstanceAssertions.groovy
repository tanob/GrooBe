package com.github.tanob.groobe

import static org.hamcrest.CoreMatchers.*
import static org.hamcrest.MatcherAssert.assertThat

/**
 */
class InstanceAssertions {
    private static def shouldBeInstanceOf = { assertThat delegate, instanceOf(it) }
    private static def shouldNotBeInstanceOf = { assertThat delegate, is(not(instanceOf(it))) }

    public static def activate() {
        shouldBeInstanceOf()
        shouldNotBeInstanceOf()
    }

    private static def shouldNotBeInstanceOf() {
        Object.metaClass.shouldNotBeA = shouldNotBeInstanceOf
        Object.metaClass.shouldNotBeAn = shouldNotBeInstanceOf
    }

    private static def shouldBeInstanceOf() {
        Object.metaClass.shouldBeA = shouldBeInstanceOf
        Object.metaClass.shouldBeAn = shouldBeInstanceOf
    }
}
