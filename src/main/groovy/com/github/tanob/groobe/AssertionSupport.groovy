package com.github.tanob.groobe

import static org.hamcrest.MatcherAssert.assertThat

/**
 */
class AssertionSupport {
    public static def assertTransformedDelegateAndNoParams(transform, wrappedMatcher) {
        { failureMessage = null ->
            assertWithFailureMessage transform(delegate), wrappedMatcher(), failureMessage
        }
    }

    public static def assertDelegateAndOneParam(wrappedMatcher) {
        assertTransformedDelegateAndOneParam({ it }, wrappedMatcher)
    }

    public static def assertTransformedDelegateAndOneParam(transform, wrappedMatcher) {
        { expected = null, failureMessage = null ->
            assertWithFailureMessage transform(delegate), wrappedMatcher(expected), failureMessage
        }
    }

    public static def assertDelegateAndTwoParams(wrappedMatcher) {
        { param1, param2, failureMessage = null ->
            assertWithFailureMessage delegate, wrappedMatcher(param1, param2), failureMessage
        }
    }

    public static def assertWithFailureMessage(delegate, matcher, failureMessage) {
        if (failureMessage) {
            assertThat failureMessage, delegate, matcher
        }
        else {
            assertThat delegate, matcher
        }
    }
}
