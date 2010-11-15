package com.github.tanob.groobe

import com.github.tanob.groobe.assertions.BooleanAssertions
import com.github.tanob.groobe.assertions.CharSequenceAssertions
import com.github.tanob.groobe.assertions.NumberAssertions
import com.github.tanob.groobe.hamcrest.*

abstract class AssertionsLoaderFactory {

    static final AssertionsLoader SIMPLE = new CompositeAssertionsLoader(
        new BooleanAssertions(),
        new NumberAssertions(),
        new CharSequenceAssertions())

    static final AssertionsLoader HAMCREST = new CompositeAssertionsLoader(
        new CollectionAssertions(),
        new ComparableAssertions(),
        new EqualityAssertions(),
        new InstanceAssertions(),
        new MapAssertions(),
        new com.github.tanob.groobe.assertions.StringAssertions()
    )

    static AssertionsLoader composite(AssertionsLoader[] loaders) {
        new CompositeAssertionsLoader(loaders)
    }

}
