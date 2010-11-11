package com.github.tanob.groobe.assertions

class StringAssertions implements AssertionsLoader {

    private def _stringTypes = [String.metaClass, GString.metaClass]

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
        _stringTypes.each {
            it.getShouldBeEmpty = {
                _shouldBeEmpty delegate
            }

            it.shouldBeEmpty = {String description ->
                _shouldBeEmpty delegate, description
            }

            it.getShouldHaveLength = {
                _shouldHaveAnyLength delegate
            }

            it.shouldHaveLength = {String description ->
                _shouldHaveAnyLength delegate, description
            }

            it.shouldHaveLength = {int length,
                                   String description = "length=${length} expected, not ${delegate.length()}" ->
                _shouldHaveLength delegate, length, description
            }

            it.getShouldHaveText = {
                _shouldHaveText delegate
            }

            it.shouldHaveText = {String failMessage ->
                _shouldHaveText delegate, failMessage
            }
        }
    }

    def void unload() {
        String.metaClass = null
    }

}
