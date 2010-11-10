package com.github.tanob.groobe

import static org.hamcrest.CoreMatchers.not
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.collection.IsCollectionContaining.hasItem

/**
 */
class CollectionAssertions {
    public static def activate() {
        Collection.metaClass.shouldContain = { assertThat delegate, hasItem(it) }
        Collection.metaClass.shouldNotContain = { assertThat delegate, not(hasItem(it)) }
    }
}
