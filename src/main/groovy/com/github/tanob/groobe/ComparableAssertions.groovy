package com.github.tanob.groobe

import static org.hamcrest.Matchers.greaterThan
import static org.hamcrest.Matchers.lessThan
import static com.github.tanob.groobe.AssertionSupport.assertDelegate

/**
 */
class ComparableAssertions {
    public static def activate() {
        Comparable.metaClass.shouldBeGreaterThan = assertDelegate { greaterThan(it) }
        Comparable.metaClass.shouldBeLessThan = assertDelegate { lessThan(it) }
    }
}
