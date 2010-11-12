package com.github.tanob.groobe

import com.github.tanob.groobe.hamcrest.*

/**
 */
abstract class GrooBe {

    private static AssertionsLoader loaderImpl

    public static void load(AssertionsLoader loader = AssertionsLoaderFactory.SIMPLE) {
        unload()
        loaderImpl = loader
        loaderImpl?.load()
    }

    public static void unload() {
        loaderImpl?.unload()
        loaderImpl = null
    }

}