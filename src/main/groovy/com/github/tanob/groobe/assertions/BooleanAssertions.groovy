package com.github.tanob.groobe.assertions

import com.github.tanob.groobe.AssertionsLoader
import static com.github.tanob.groobe.assertions.AssertionsSupport.assertTrue

class BooleanAssertions implements AssertionsLoader {

    private def _shouldBe = {Boolean expected, Boolean result, String failMessage ->
        assertTrue failMessage, result == expected
    }

    void load() {
        Boolean.metaClass.isShouldBeTrue = {
            _shouldBe true, delegate, "NOT true as expected"
        }

        Boolean.metaClass.shouldBeTrue = {String failMessage ->
            _shouldBe true, delegate, failMessage
        }

        Boolean.metaClass.isShouldBeFalse = {
            _shouldBe false, delegate, "NOT false as expected"
        }

        Boolean.metaClass.shouldBeFalse = {String failMessage ->
            _shouldBe false, delegate, failMessage
        }
    }

    void unload() {
        Boolean.metaClass = null
    }

}
