package com.github.tanob.groobe

import static com.github.tanob.groobe.AssertionSupport.assertDelegate
import static org.hamcrest.CoreMatchers.not
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.*

/**
 */
class MapAssertions {
    public static def activate() {
        Map.metaClass.shouldHaveKey = assertDelegate { hasKey(it) }
        Map.metaClass.shouldHaveValue = assertDelegate { hasValue(it) }
        Map.metaClass.shouldHaveEntry = assertDelegateWithTwoParams { key, value -> hasEntry(key, value) }

        Map.metaClass.shouldNotHaveKey = assertDelegate { not(hasKey(it)) }
        Map.metaClass.shouldNotHaveValue = assertDelegate { not(hasValue(it)) }
        Map.metaClass.shouldNotHaveEntry = assertDelegateWithTwoParams { key, value -> not(hasEntry(key, value)) }
    }

    private static def assertDelegateWithTwoParams(wrappedMatcher) {
        { key, value, failureMessage = null ->
            if (failureMessage) {
                assertThat failureMessage, delegate, wrappedMatcher(key, value)
            }
            else {
                assertThat delegate, wrappedMatcher(key, value)
            }
        }
    }
}
