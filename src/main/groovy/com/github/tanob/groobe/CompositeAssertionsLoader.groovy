package com.github.tanob.groobe

class CompositeAssertionsLoader implements AssertionsLoader {

    private AssertionsLoader[] assertions;

    def CompositeAssertionsLoader(AssertionsLoader[] assertions) {
        this.assertions = assertions
    }

    final void load() {
        assertions*.load()
    }

    final void unload() {
        assertions*.unload()
    }

}
