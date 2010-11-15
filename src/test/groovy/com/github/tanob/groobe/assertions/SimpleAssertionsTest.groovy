package com.github.tanob.groobe.assertions

class SimpleAssertionsTest extends GroovyTestCase {

    SimpleAssertions simpleAssertions = SimpleAssertions.instance

    void testHasAllAssertions() {
        def expectedAssertions = [
            BooleanAssertions.instance,
            NumberAssertions.instance,
            CharSequenceAssertions.instance
        ]

        expectedAssertions.each {
            simpleAssertions.hasAssertion(it)
        }
    }

}
