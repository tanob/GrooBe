package com.github.tanob.groobe.hamcrest

import com.github.tanob.groobe.AssertionsLoader
import static org.hamcrest.CoreMatchers.not
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.collection.IsCollectionContaining.hasItem
import static org.hamcrest.number.OrderingComparisons.greaterThan

class CollectionAssertions implements AssertionsLoader {

    def void load() {
        Collection.metaClass.shouldContain = { assertThat delegate, hasItem(it) }
        Collection.metaClass.shouldNotContain = { assertThat delegate, not(hasItem(it)) }
        Collection.metaClass.shouldBeEmpty = { assertThat delegate.size(), is(0) }
        Collection.metaClass.shouldNotBeEmpty = { assertThat delegate.size(), greaterThan(0) }
    }

    def void unload() {
        Collection.metaClass = null
    }

}
