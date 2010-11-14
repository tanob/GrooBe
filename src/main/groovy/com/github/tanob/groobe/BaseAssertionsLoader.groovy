package com.github.tanob.groobe

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

}
