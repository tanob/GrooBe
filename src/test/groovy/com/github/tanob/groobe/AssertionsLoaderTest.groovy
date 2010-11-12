package com.github.tanob.groobe

import org.junit.After
import org.junit.Before
import static org.junit.Assert.fail

abstract class AssertionsLoaderTest {

    @Before
    final void loadAssertions() {
        getAssertionsLoader().load()
    }

    @After
    final void unloadAssertions() {
        getAssertionsLoader().unload()
    }

    abstract AssertionsLoader getAssertionsLoader()

    void shouldFail(String customFailMessage, Closure failMessageAssertion, Closure failedStatement) {
        try {
            failedStatement()
            fail()
        } catch (AssertionError e) {
            failMessageAssertion(e, customFailMessage)
        }
    }

}
