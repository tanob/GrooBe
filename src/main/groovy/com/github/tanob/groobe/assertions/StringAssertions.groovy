package com.github.tanob.groobe.assertions

import com.github.tanob.groobe.BaseAssertionsLoader
import static com.github.tanob.groobe.assertions.Assert.assertTrue

class StringAssertions extends BaseAssertionsLoader {

    def StringAssertions(Class charSequenceSubType) {
        super(charSequenceSubType)
    }

    def shouldBeBlank(CharSequence delegate, Object[] args) {
        String failMessage = args.length > 0 ? args[0] : "BLANK String expected, not '$delegate'"
        assertTrue failMessage, delegate.length() == 0
    }

    def shouldNotBeBlank(CharSequence delegate, Object[] args) {
        String failMessage = args.length > 0 ? args[0] : "NOT expecting a blank String"
        assertTrue failMessage, delegate.length() > 0
    }

    def shouldHaveText(CharSequence delegate, Object[] args) {
        String failMessage = args.length > 0 ? args[0] : "String with visible text content expected"
        assertTrue failMessage, delegate.trim().length() > 0
    }

    String getShouldBeDefaultMessage(Object expected, Object actual) {
        "Strings doesn't match: expecting '$expected', not '$actual'"
    }

    def shouldBeIgnoringCase(CharSequence delegate, Object[] args) {
        String failMessage = args.length > 1 ? args[1] : "Strings doesn't match: expecting '${args[0]}', not '$delegate'"
        assertTrue failMessage, delegate.equalsIgnoreCase(args[0])
    }

    def shouldBeEqualsToIgnoringCase(CharSequence delegate, Object[] args) {
        shouldBeIgnoringCase delegate, args
    }

    def shouldNotBe(CharSequence delegate, Object[] args) {
        String failMessage = args.length > 1 ? args[1] : "Strings not supposed to match, but they do"
        assertTrue failMessage, delegate != args[0]
    }

    def shouldNotBeEqualsTo(CharSequence delegate, Object[] args) {
        shouldNotBe delegate, args
    }

}
