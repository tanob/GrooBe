package com.github.tanob.groobe

import static org.hamcrest.Matchers.greaterThan
import static org.hamcrest.Matchers.lessThan
import static com.github.tanob.groobe.AssertionSupport.assertDelegateAndOneParam

/**
 */
class ComparableAssertions {
    public static def activate() {
        Comparable.metaClass.shouldBeGreaterThan = assertDelegateAndOneParam { greaterThan(it) }
        Comparable.metaClass.shouldBeLessThan = assertDelegateAndOneParam { lessThan(it) }
    }
}
