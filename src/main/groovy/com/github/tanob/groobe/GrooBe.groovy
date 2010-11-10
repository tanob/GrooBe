package com.github.tanob.groobe

/**
 */
abstract class GrooBe {
    public static void activate() {
        EqualityAssertions.activate()
        InstanceAssertions.activate()
        ComparableAssertions.activate()
        StringAssertions.activate()
        MapAssertions.activate()
        CollectionAssertions.activate()
    }
}
