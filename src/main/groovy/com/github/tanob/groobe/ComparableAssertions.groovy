package com.github.tanob.groobe

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.greaterThan
import static org.hamcrest.Matchers.lessThan

/**
 */
class ComparableAssertions {
    public static def activate() {
        Comparable.metaClass.shouldBeGreaterThan = { assertThat delegate, greaterThan(it) }
        Comparable.metaClass.shouldBeLessThan = { assertThat delegate, lessThan(it) }
    }
}
