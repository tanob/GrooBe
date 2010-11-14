package com.github.tanob.groobe

abstract class AssertionsLoaderTest extends GroovyTestCase {

    void setUp() {
        assertionsLoader.load()
    }

    void tearDown() {
        assertionsLoader.unload()
    }

    void testAssertionsMissingAfterUnload() {
        fail "NOT yet implemented"
    }

    void testOtherAssertionsShouldRemainAvailableAfterUnload() {
        fail "NOT yet implemented"
    }

    abstract AssertionsLoader getAssertionsLoader()

    void shouldFail(String customFailMessage, Closure failMessageAssertion, Closure failedStatement) {
        boolean failed = false;

        try {
            failedStatement()
        } catch (AssertionError e) {
            failed = true
            failMessageAssertion(e, customFailMessage)

        } catch (Throwable unexpected) {
            throw new AssertionError("method did not failed as expected")
        }

        if (!failed) {
            throw new AssertionError("method should have failed")
        }
    }

}
