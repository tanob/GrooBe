package com.github.tanob.groobe

import static org.hamcrest.CoreMatchers.not
import static org.hamcrest.collection.IsCollectionContaining.hasItem
import static org.hamcrest.core.Is.is
import static org.hamcrest.number.OrderingComparisons.greaterThan
import static com.github.tanob.groobe.AssertionSupport.assertDelegateAndOneParam
import static com.github.tanob.groobe.AssertionSupport.assertTransformedDelegateAndNoParams

/**
 */
class CollectionAssertions {
    public static def activate() {
        Collection.metaClass.shouldContain = assertDelegateAndOneParam { hasItem(it) }
        Collection.metaClass.shouldNotContain = assertDelegateAndOneParam { not(hasItem(it)) }

        def size = { it.size() }

        Collection.metaClass.shouldBeEmpty = assertTransformedDelegateAndNoParams(size, { is(0) })
        Collection.metaClass.shouldNotBeEmpty = assertTransformedDelegateAndNoParams(size, { greaterThan(0) })
    }
}
