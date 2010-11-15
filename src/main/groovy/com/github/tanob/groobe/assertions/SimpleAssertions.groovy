package com.github.tanob.groobe.assertions

import com.github.tanob.groobe.AssertionsLoader
import com.github.tanob.groobe.CompositeAssertionsLoader

@Singleton
class SimpleAssertions implements AssertionsLoader {

    private final assertions = [
        BooleanAssertions.instance,
        NumberAssertions.instance,
        CharSequenceAssertions.instance
    ]

    private final CompositeAssertionsLoader compositeDelegate = new CompositeAssertionsLoader(assertions)

    void load() {
        compositeDelegate.load()
    }

    void unload() {
        compositeDelegate.unload()
    }

    boolean hasAssertion(AssertionsLoader assertionsLoader) {
        assertions.contains(assertionsLoader)
    }
    
}
