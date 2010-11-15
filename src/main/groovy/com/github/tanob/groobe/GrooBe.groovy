package com.github.tanob.groobe

import com.github.tanob.groobe.assertions.SimpleAssertions

/**
 */
abstract class GrooBe {

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

}