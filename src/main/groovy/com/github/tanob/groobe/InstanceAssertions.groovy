package com.github.tanob.groobe

import static org.hamcrest.CoreMatchers.*
import static com.github.tanob.groobe.AssertionSupport.assertDelegateAndOneParam

/**
 */
class InstanceAssertions {
    private static def shouldBeInstanceOf = assertDelegateAndOneParam { instanceOf(it) }
    private static def shouldNotBeInstanceOf = assertDelegateAndOneParam { is(not(instanceOf(it))) }

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
