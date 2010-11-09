package com.github.tanob.groobe.assertions

import static org.junit.Assert.assertTrue

class StringAssertions implements AssertionsLoader {

    def void load() {
        String.metaClass.getShouldBeEmpty = {
            assertTrue("EMPTY String expected, not '${delegate}'",
                "" == delegate)
        }

        String.metaClass.shouldBeEmpty = {String description ->
            assertTrue(description, "" == delegate)
        }

        String.metaClass.getShouldHaveLength = {
            assertTrue("NOT EMPTY String expected", delegate.length() > 0)
        }

        String.metaClass.shouldHaveLength = {String description ->
            assertTrue(description, delegate.length() > 0)
        }

        String.metaClass.shouldHaveLength = {int length,
                                             String description = "length=${length} expected, not ${delegate.length()}" ->
            assertTrue(description, delegate.length() == length)
        }

        String.metaClass.getShouldHaveText = {
            assertTrue("String with text content expected", delegate.trim().length() > 0)
        }

        String.metaClass.shouldHaveText = {String failMessage ->
            assertTrue(failMessage, delegate.trim().length() > 0)
        }
    }

    def void unload() {
        String.metaClass = null
    }
}
