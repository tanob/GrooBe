package com.github.tanob.groobe.assertions

class Assert {

    static void assertTrue(String failMessage, boolean condition) {
        if (!condition) {
            throw new AssertionError(failMessage)
        }
    }

    private Assert() {
        throw new UnsupportedOperationException("${this.class.name} is a utility class. You should not try to create instances of it.")
    }

}
