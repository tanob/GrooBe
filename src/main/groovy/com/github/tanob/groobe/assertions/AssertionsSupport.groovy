package com.github.tanob.groobe.assertions

abstract class AssertionsSupport {
    
    static def assertTrue (String failMessage, boolean result) {
        if (!result) {
            throw new AssertionError(failMessage)
        }
    }

    private AssertionsSupport() {
    }

}
