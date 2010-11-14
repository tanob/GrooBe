package com.github.tanob.groobe

import static org.hamcrest.CoreMatchers.*
import static com.github.tanob.groobe.AssertionSupport.assertDelegate

/**
 */
class InstanceAssertions {
    private static def shouldBeInstanceOf = assertDelegate { instanceOf(it) }
    private static def shouldNotBeInstanceOf = assertDelegate { is(not(instanceOf(it))) }

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
