package com.github.tanob.groobe

import com.github.tanob.groobe.assertions.SimpleAssertions

/**
 */
final class GrooBe {

    private static AssertionsLoader loaderImpl

    public static void load(AssertionsLoader loader = SimpleAssertions.instance) {
        unload()
        loaderImpl = loader
        loaderImpl?.load()
    }

    public static void unload() {
        loaderImpl?.unload()
        loaderImpl = null
    }

    def GrooBe() {
        throw new UnsupportedOperationException()
    }

}