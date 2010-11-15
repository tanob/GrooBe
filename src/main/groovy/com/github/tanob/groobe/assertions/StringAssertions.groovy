package com.github.tanob.groobe.assertions

import com.github.tanob.groobe.BaseAssertionsLoader
import static com.github.tanob.groobe.assertions.AssertionsSupport.assertTrue

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

}
