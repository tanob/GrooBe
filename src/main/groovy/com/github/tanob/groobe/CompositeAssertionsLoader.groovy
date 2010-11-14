package com.github.tanob.groobe

class CompositeAssertionsLoader implements AssertionsLoader {

    private Object assertions;

    def CompositeAssertionsLoader(Object assertions) {
        this.assertions = assertions
    }

    final void load() {
        assertions*.load()
    }

    final void unload() {
        assertions*.unload()
    }

}
