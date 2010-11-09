package com.github.tanob.groobe.assertions

import static org.junit.Assert.assertTrue

class NumberAssertions implements AssertionsLoader {
    private static def shouldBe = {Number expected,
                                   String failMessage = "expecting ${expected}, not ${delegate}" ->
        assertTrue failMessage, (delegate == expected)
    }

    void load() {
        Number.metaClass.shouldBe = shouldBe;
        Number.metaClass.shouldBeEqualsTo = shouldBe
    }

    void unload() {
        Number.metaClass = null
    }

}
