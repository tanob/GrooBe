package com.github.tanob.groobe.assertions

import com.github.tanob.groobe.BaseAssertionsLoader
import static com.github.tanob.groobe.assertions.Assert.assertTrue

class ConcreteNumberAssertion extends BaseAssertionsLoader {

    def ConcreteNumberAssertion(Class number) {
        super(number)
    }

    def shouldBe(Number delegate, Object[] args) {
        _shouldBeImpl delegate, args
    }

    def shouldBeEqualsTo(Number delegate, Object[] args) {
        _shouldBeImpl delegate, args
    }

    private void _shouldBeImpl(Number delegate, Object[] args) {
        Number expected = args[0]
        String failMessage = args.length > 1 ? args[1] : "expecting $expected, not $delegate"
        assertTrue failMessage, expected == delegate
    }

}
