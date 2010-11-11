package com.github.tanob.groobe.assertions

import org.junit.After
import org.junit.Before
import org.junit.Test
import static org.junit.Assert.assertEquals
import static org.junit.Assert.fail

abstract class AssertionsLoaderTest {

    AssertionsLoader assertionsLoader;

    def AssertionsLoaderTest(AssertionsLoader assertionsLoader) {
        this.assertionsLoader = assertionsLoader
    }

    @Before
    void loadAssertions() {
        assertionsLoader.load()
    }

    @After
    void unloadAssertions() {
        assertionsLoader.unload()
    }

    @Test
    final void testLoadAndUnload() {
        testLoad()
        assertionsLoader.unload()
        testUnload()
    }

    abstract void testLoad()

    abstract void testUnload()

    // utility methods

    void shouldFailWithMessage(String message, Closure closure) {
        try {
            closure()
            fail()
        } catch (AssertionError e) {
            assertEquals message, e.message
        }
    }

}
