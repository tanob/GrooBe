package com.github.tanob.groobe

import static com.github.tanob.groobe.AssertionSupport.assertDelegateAndOneParam
import static org.hamcrest.CoreMatchers.not
import static org.hamcrest.Matchers.*
import static com.github.tanob.groobe.AssertionSupport.assertDelegateAndTwoParams
import static com.github.tanob.groobe.AssertionSupport.assertTransformedDelegateAndNoParams

/**
 */
class MapAssertions {
    public static def activate() {
        Map.metaClass.shouldHaveKey = assertDelegateAndOneParam { hasKey(it) }
        Map.metaClass.shouldHaveValue = assertDelegateAndOneParam { hasValue(it) }
        Map.metaClass.shouldHaveEntry = assertDelegateAndTwoParams { key, value -> hasEntry(key, value) }

        Map.metaClass.shouldNotHaveKey = assertDelegateAndOneParam { not(hasKey(it)) }
        Map.metaClass.shouldNotHaveValue = assertDelegateAndOneParam { not(hasValue(it)) }
        Map.metaClass.shouldNotHaveEntry = assertDelegateAndTwoParams { key, value -> not(hasEntry(key, value)) }

        def size = { it.size() }

        Map.metaClass.shouldBeEmpty = assertTransformedDelegateAndNoParams(size, { is(0) })
        Map.metaClass.shouldNotBeEmpty = assertTransformedDelegateAndNoParams(size, { greaterThan(0) })
    }
}
