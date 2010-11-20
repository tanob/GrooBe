package com.github.tanob.groobe

import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.CoreMatchers.not
import static com.github.tanob.groobe.AssertionSupport.assertTransformedDelegateAndOneParam

/**
 */
public class EqualityAssertions {
    private static def fixingNull = { it.equals(null) ? null : it }
    private static def shouldBeEqualTo = assertTransformedDelegateAndOneParam (fixingNull, { is(it) })
    private static def shouldNotBeEqualTo = assertTransformedDelegateAndOneParam (fixingNull, { is(not(it)) })

    public static def activate() {
        shouldBeEqual()
        shouldNotBeEqual()
    }

    private static def shouldNotBeEqual() {
        Object.metaClass.shouldNotBe = shouldNotBeEqualTo
        Object.metaClass.shouldNotEqual = shouldNotBeEqualTo
        Object.metaClass.shouldNotBeEqual = shouldNotBeEqualTo
        Object.metaClass.shouldNotBeEqualTo = shouldNotBeEqualTo
    }

    private static def shouldBeEqual() {
        Object.metaClass.shouldBe = shouldBeEqualTo
        Object.metaClass.shouldEqual = shouldBeEqualTo
        Object.metaClass.shouldBeEqual = shouldBeEqualTo
        Object.metaClass.shouldBeEqualTo = shouldBeEqualTo
    }
}
