package com.github.tanob.groobe

import static com.github.tanob.groobe.AssertionSupport.assertDelegateAndOneParam
import static com.github.tanob.groobe.AssertionSupport.assertTransformedDelegateAndOneParam
import static org.hamcrest.Matchers.*
import static com.github.tanob.groobe.AssertionSupport.assertTransformedDelegateAndNoParams

/**
 */
class StringAssertions {
    public static def activate() {
        def string = { it.toString() }

        CharSequence.metaClass.shouldStartWith = assertTransformedDelegateAndOneParam(string, { startsWith(it.toString()) })
        CharSequence.metaClass.shouldNotStartWith = assertDelegateAndOneParam { not(startsWith(it.toString())) }

        CharSequence.metaClass.shouldEndWith = assertTransformedDelegateAndOneParam(string, { endsWith(it.toString()) })
        CharSequence.metaClass.shouldNotEndWith = assertDelegateAndOneParam { not(endsWith(it.toString())) }

        CharSequence.metaClass.shouldContain = assertTransformedDelegateAndOneParam(string, { containsString(it.toString()) })
        CharSequence.metaClass.shouldNotContain = assertDelegateAndOneParam { not(containsString(it.toString())) }

        def length = { it.length() }

        CharSequence.metaClass.shouldBeEmpty = assertTransformedDelegateAndNoParams(length, { is(0) })
        CharSequence.metaClass.shouldNotBeEmpty = assertTransformedDelegateAndNoParams(length, { greaterThan(0) })

        CharSequence.metaClass.shouldBe = assertTransformedDelegateAndOneParam(string, { is(it.toString()) })
        CharSequence.metaClass.shouldNotBe = assertTransformedDelegateAndOneParam(string, { is(not(it.toString())) })
    }
}
