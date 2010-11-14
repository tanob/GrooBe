package com.github.tanob.groobe

import static org.hamcrest.MatcherAssert.assertThat

/**
 */
class AssertionSupport {
    public static def assertDelegate(wrappedMatcher) {
        assertTransformedDelegate({ it }, wrappedMatcher)
    }

    public static def assertTransformedDelegate(transform, wrappedMatcher) {
        { expected = null, failureMessage = null ->
            if (failureMessage) {
                assertThat failureMessage, transform(delegate), wrappedMatcher(expected)
            }
            else {
                assertThat transform(delegate), wrappedMatcher(expected)
            }
        }
    }
}
