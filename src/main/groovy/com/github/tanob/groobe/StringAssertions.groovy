package com.github.tanob.groobe

import static com.github.tanob.groobe.AssertionSupport.assertDelegate
import static com.github.tanob.groobe.AssertionSupport.assertTransformedDelegate
import static org.hamcrest.Matchers.*
import static org.hamcrest.MatcherAssert.assertThat

/**
 */
class StringAssertions {
    public static def activate() {
        def string = { it.toString() }

        CharSequence.metaClass.shouldStartWith = assertTransformedDelegate(string, { startsWith(it.toString()) })
        CharSequence.metaClass.shouldNotStartWith = assertDelegate { not(startsWith(it.toString())) }

        CharSequence.metaClass.shouldEndWith = assertTransformedDelegate(string, { endsWith(it.toString()) })
        CharSequence.metaClass.shouldNotEndWith = assertDelegate { not(endsWith(it.toString())) }

        CharSequence.metaClass.shouldContain = assertTransformedDelegate(string, { containsString(it.toString()) })
        CharSequence.metaClass.shouldNotContain = assertDelegate { not(containsString(it.toString())) }

        def length = { it.length() }

        CharSequence.metaClass.shouldBeEmpty = assertTransformedDelegateWithNoParams(length, { is(0) })
        CharSequence.metaClass.shouldNotBeEmpty = assertTransformedDelegateWithNoParams(length, { greaterThan(0) })
    }

    private static def assertTransformedDelegateWithNoParams(transform, wrappedMatcher) {
        { failureMessage = null ->
            if (failureMessage) {
                assertThat failureMessage, transform(delegate), wrappedMatcher()
            }
            else {
                assertThat transform(delegate), wrappedMatcher()
            }
        }
    }
}
