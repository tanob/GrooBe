package com.github.tanob.groobe.hamcrest

import com.github.tanob.groobe.AssertionsLoader
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.*

class StringAssertions implements AssertionsLoader {

    def void load() {
        String.metaClass.shouldStartWith = { assertThat delegate, startsWith(it) }
        String.metaClass.shouldNotStartWith = { assertThat delegate, not(startsWith(it)) }

        String.metaClass.shouldEndWith = { assertThat delegate, endsWith(it) }
        String.metaClass.shouldNotEndWith = { assertThat delegate, not(endsWith(it)) }

        String.metaClass.shouldContain = { assertThat delegate, containsString(it) }
        String.metaClass.shouldNotContain = { assertThat delegate, not(containsString(it)) }

        String.metaClass.shouldBeEmpty = { assertThat delegate.length(), is(0) }
        String.metaClass.shouldNotBeEmpty = { assertThat delegate.length(), greaterThan(0) }
    }

    def void unload() {
        String.metaClass = null
    }

}