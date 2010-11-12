package com.github.tanob.groobe.assertions

import com.github.tanob.groobe.AssertionsLoader
import static com.github.tanob.groobe.assertions.AssertionsSupport.assertTrue

class NumberAssertions implements AssertionsLoader {

    private def _shouldBe = {Number expected,
                             String failMessage = "expecting ${expected}, not ${delegate}" ->
        assertTrue(failMessage, delegate == expected)
    }

    void load() {
        Number.metaClass.shouldBe = _shouldBe;
        Number.metaClass.shouldBeEqualsTo = _shouldBe
    }

    void unload() {
        Number.metaClass = null
    }

}
