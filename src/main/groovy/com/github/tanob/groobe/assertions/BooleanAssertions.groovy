package com.github.tanob.groobe.assertions

import com.github.tanob.groobe.BaseAssertionsLoader
import static com.github.tanob.groobe.assertions.Assert.assertTrue

@Singleton
class BooleanAssertions extends BaseAssertionsLoader {

    def BooleanAssertions() {
        super(Boolean)
    }

    String getShouldBeDefaultMessage(Object expected, Object actual) {
        "NOT $expected as expected"
    }

    def shouldBeTrue(boolean delegate, Object[] args) {
        _shouldBeImpl delegate, true, args
    }

    def shouldBeFalse(boolean delegate, Object[] args) {
        _shouldBeImpl delegate, false, args
    }

    private void _shouldBeImpl(boolean delegate, boolean expected, Object[] args) {
        String failMessage = args.length == 0 ? "NOT $expected as expected" : args[0]
        assertTrue failMessage, expected == delegate
    }

}