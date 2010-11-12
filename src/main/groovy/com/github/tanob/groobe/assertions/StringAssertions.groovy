package com.github.tanob.groobe.assertions

import com.github.tanob.groobe.AssertionsLoader
import static com.github.tanob.groobe.assertions.AssertionsSupport.assertTrue

class StringAssertions implements AssertionsLoader {

    private def _shouldBeEmpty = {String result, String failMessage = "EMPTY String expected, not '${result}'" ->
        assertTrue failMessage, "" == result
    }

    private def _shouldHaveAnyLength = {String result, String failMessage = "NOT expecting an empty String" ->
        assertTrue failMessage, result.length() > 0
    }

    private def _shouldHaveLength = {String result, int expectedLength, String failMessage = "length=${expectedLength} expected, not ${result.length()}" ->
        assertTrue failMessage, result.length() == expectedLength
    }

    private def _shouldHaveText = {String result, String failMessage = "String with text content expected" ->
        assertTrue failMessage, result.trim().length() > 0
    }

    void load() {
        CharSequence.metaClass.getShouldBeEmpty = {
            _shouldBeEmpty delegate
        }

        CharSequence.metaClass.shouldBeEmpty = {String description ->
            _shouldBeEmpty delegate, description
        }

        CharSequence.metaClass.getShouldHaveLength = {
            _shouldHaveAnyLength delegate
        }

        CharSequence.metaClass.shouldHaveLength = {String description ->
            _shouldHaveAnyLength delegate, description
        }

        CharSequence.metaClass.shouldHaveLength = {int length,
                                                   String description = "length=${length} expected, not ${delegate.length()}" ->
            _shouldHaveLength delegate, length, description
        }

        CharSequence.metaClass.getShouldHaveText = {
            _shouldHaveText delegate
        }

        CharSequence.metaClass.shouldHaveText = {String failMessage ->
            _shouldHaveText delegate, failMessage
        }
    }

    def void unload() {
        CharSequence.metaClass = null
    }

}
