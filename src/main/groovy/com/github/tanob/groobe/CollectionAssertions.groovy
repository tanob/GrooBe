package com.github.tanob.groobe

import static org.hamcrest.CoreMatchers.not
import static org.hamcrest.collection.IsCollectionContaining.hasItem
import static org.hamcrest.core.Is.is
import static org.hamcrest.number.OrderingComparisons.greaterThan
import static com.github.tanob.groobe.AssertionSupport.assertDelegate
import static org.hamcrest.MatcherAssert.assertThat

/**
 */
class CollectionAssertions {
    public static def activate() {
        Collection.metaClass.shouldContain = assertDelegate { hasItem(it) }
        Collection.metaClass.shouldNotContain = assertDelegate { not(hasItem(it)) }

        def size = { it.size() }

        Collection.metaClass.shouldBeEmpty = assertTransformedDelegateWithNoParams(size, { is(0) })
        Collection.metaClass.shouldNotBeEmpty = assertTransformedDelegateWithNoParams(size, { greaterThan(0) })
    }

    private static def assertTransformedDelegateWithNoParams(transform, wrappedMatcher) {
        { failureMessage = null ->
            if (failureMessage) {
                assertThat failureMessage, transform(delegate), wrappedMatcher()
            }
            else {
                assertThat transform(delegate), wrappedMatcher()
            }
        }
    }
}
