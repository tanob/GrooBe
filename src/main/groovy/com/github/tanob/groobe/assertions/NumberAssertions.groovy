package com.github.tanob.groobe.assertions

import com.github.tanob.groobe.AssertionsLoader
import com.github.tanob.groobe.CompositeAssertionsLoader

@Singleton
class NumberAssertions implements AssertionsLoader {

    static final NUMBER_CLASSES = [
        Byte, Short, Integer, Float, Long, Double, BigDecimal, BigInteger
    ]

    private AssertionsLoader delegate

    def NumberAssertions() {
        def assertions = NUMBER_CLASSES.collect {
            new ConcreteNumberAssertion(it)
        }
        delegate = new CompositeAssertionsLoader(assertions)
    }

    def void load() {
        delegate.load()
    }

    def void unload() {
        delegate.unload()
    }

}