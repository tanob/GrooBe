package com.github.tanob.groobe

import com.github.tanob.groobe.assertions.SimpleAssertions
import groovy.mock.interceptor.MockFor

class GrooBeTest extends GroovyTestCase {

    void tearDown() {
        GrooBe.unload()
    }

    void testInitiallyUnloaded() {
        assertNull GrooBe.loaderImpl
    }

    void testSimpleAssertionsLoadedByDefault() {
        GrooBe.load()
        assertSame SimpleAssertions.instance, GrooBe.loaderImpl
    }

    void testLoadShouldUnloadPreviousAssertions() {
        def mock = new MockFor(AssertionsLoader)
        mock.demand.load() {}
        mock.demand.unload() {}
        AssertionsLoader loader = mock.proxyInstance()

        GrooBe.load loader
        GrooBe.load SimpleAssertions.instance

        mock.verify loader
    }

    void testNoInstancesAllowed() {
        shouldFail UnsupportedOperationException, {
            new GrooBe()
        }
    }

}
