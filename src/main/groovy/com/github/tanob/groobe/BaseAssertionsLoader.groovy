package com.github.tanob.groobe

import static com.github.tanob.groobe.assertions.Assert.assertTrue

abstract class BaseAssertionsLoader extends DelegatingMetaClass implements AssertionsLoader {

    private def loaded

    private Class extendedClass

    def BaseAssertionsLoader(Class extendedClass) {
        super(extendedClass)
        this.extendedClass = extendedClass
        initialize()
    }

    void load() {
        if (!loaded) {
            GroovySystem.metaClassRegistry.setMetaClass extendedClass, this
            loaded = this;
        }
    }

    void unload() {
        loaded = null
    }

    def getProperty(Object delegate, String property) {
        try {
            super.getProperty(delegate, property)
        } catch (MissingPropertyException e) {
            if (loaded) {
                "${property}"(delegate)
            }
            else {
                throw e
            }
        }
    }

    def invokeMethod(Object delegate, String methodName, Object[] args) {
        try {
            super.invokeMethod(delegate, methodName, args)
        } catch (MissingMethodException e) {
            if (loaded) {
                "${methodName}"(delegate, args)
            }
            else {
                throw e
            }
        }
    }

    // object assertions

    def shouldBe(Object delegate, Object[] args) {
        String failMessage = args.length > 1 ? args[1] : getShouldBeDefaultMessage(args[0], delegate)
        assertTrue failMessage, args[0] == delegate
    }

    def shouldBeEqualsTo(Object delegate, Object[] args) {
        shouldBe delegate, args
    }

    String getShouldBeDefaultMessage(Object expected, Object actual) {
        "expecting $expected, not $actual"
    }

    def shouldNotBe(Object delegate, Object[] args) {
        String failMessage = args.length > 1 ? args[1] : getShouldNotBeDefaultMessage(args[0], delegate)
        assertTrue failMessage, args[0] != delegate
    }

    def shouldNotBeEqualsTo(Object delegate, Object[] args) {
        shouldNotBe delegate, args
    }

    String getShouldNotBeDefaultMessage(Object expected, Object actual) {
        "NOT expecting $expected"
    }

}
