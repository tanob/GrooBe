package com.github.tanob.groobe.assertions

class AssertTest extends GroovyTestCase {

    void testConstructorNotAvailable() {
        shouldFail UnsupportedOperationException, {
            new Assert()
        }
    }

    void testAssertTrue() {
        Assert.assertTrue "message", true
    }

    void testFailedAssertTrue() {
        try {
            Assert.assertTrue "message", false
            fail()
        } catch (AssertionError e) {
            assertEquals "message", e.message
        }
    }

}
