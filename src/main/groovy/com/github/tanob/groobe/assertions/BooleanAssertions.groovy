package com.github.tanob.groobe.assertions

import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

class BooleanAssertions implements AssertionsLoader {

    def void load() {
        Boolean.metaClass.isShouldBeTrue = {
            assertTrue "NOT true as expected", delegate
        }

        Boolean.metaClass.shouldBeTrue = {String failMessage ->
            assertTrue failMessage, delegate
        }

        Boolean.metaClass.isShouldBeFalse = {
            assertFalse "NOT false as expected", delegate
        }

        Boolean.metaClass.shouldBeFalse = {String failMessage ->
            assertFalse failMessage, delegate
        }
    }

    def void unload() {
        Boolean.metaClass = null
    }
}
