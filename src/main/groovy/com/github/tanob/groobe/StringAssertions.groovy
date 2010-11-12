package com.github.tanob.groobe

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.*

/**
 */
class StringAssertions {
    public static def activate() {
        CharSequence.metaClass.shouldStartWith = { assertThat delegate.toString(), startsWith(it.toString()) }
        CharSequence.metaClass.shouldNotStartWith = { assertThat delegate, not(startsWith(it.toString())) }

        CharSequence.metaClass.shouldEndWith = { assertThat delegate.toString(), endsWith(it.toString()) }
        CharSequence.metaClass.shouldNotEndWith = { assertThat delegate, not(endsWith(it.toString())) }

        CharSequence.metaClass.shouldContain = { assertThat delegate.toString(), containsString(it.toString()) }
        CharSequence.metaClass.shouldNotContain = { assertThat delegate, not(containsString(it.toString())) }

        CharSequence.metaClass.shouldBeEmpty = { assertThat delegate.length(), is(0) }
        CharSequence.metaClass.shouldNotBeEmpty = { assertThat delegate.length(), greaterThan(0) }
    }
}
