package com.github.tanob.groobe.assertions

interface AssertionsLoader {

    public static def assertTrue = {String failMessage, boolean result ->
        if (!result) {
            throw new AssertionError(failMessage)
        }
    }

    void load()

    void unload()

}
