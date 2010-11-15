package com.github.tanob.groobe.assertions

import com.github.tanob.groobe.AssertionsLoader
import com.github.tanob.groobe.CompositeAssertionsLoader
import org.codehaus.groovy.runtime.GStringImpl

@Singleton
class CharSequenceAssertions implements AssertionsLoader {

    static final CHAR_SEQUENCE_IMPLEMENTATIONS = [
        String, GStringImpl
    ]

    private AssertionsLoader delegate

    def CharSequenceAssertions() {
        def assertions = CHAR_SEQUENCE_IMPLEMENTATIONS.collect {
            new StringAssertions(it)
        }
        delegate = new CompositeAssertionsLoader(assertions)
    }

    def void load() {
        delegate.load()
    }

    def void unload() {
        delegate.unload()
    }

}
