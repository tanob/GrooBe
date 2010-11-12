package com.github.tanob.groobe.hamcrest

import com.github.tanob.groobe.AssertionsLoader
import static org.hamcrest.CoreMatchers.instanceOf
import static org.hamcrest.CoreMatchers.not
import static org.hamcrest.MatcherAssert.assertThat

class InstanceAssertions implements AssertionsLoader {
    private def shouldBeInstanceOf = { assertThat delegate, instanceOf(it) }
    private def shouldNotBeInstanceOf = { assertThat delegate, is(not(instanceOf(it))) }

    def void load() {
        shouldBeInstanceOf()
        shouldNotBeInstanceOf()
    }

    private def shouldNotBeInstanceOf() {
        Object.metaClass.shouldNotBeA = shouldNotBeInstanceOf
        Object.metaClass.shouldNotBeAn = shouldNotBeInstanceOf
    }

    private def shouldBeInstanceOf() {
        Object.metaClass.shouldBeA = shouldBeInstanceOf
        Object.metaClass.shouldBeAn = shouldBeInstanceOf
    }

    def void unload() {
        Object.metaClass = null
    }

}
