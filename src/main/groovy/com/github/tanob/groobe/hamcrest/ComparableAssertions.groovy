package com.github.tanob.groobe.hamcrest

import com.github.tanob.groobe.AssertionsLoader
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.greaterThan
import static org.hamcrest.Matchers.lessThan

class ComparableAssertions implements AssertionsLoader {

    def void load() {
        Comparable.metaClass.shouldBeGreaterThan = { assertThat delegate, greaterThan(it) }
        Comparable.metaClass.shouldBeLessThan = { assertThat delegate, lessThan(it) }
    }

    def void unload() {
        Comparable.metaClass = null
    }

}
