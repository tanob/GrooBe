package com.github.tanob.groobe

import org.hamcrest.Matcher
import static org.hamcrest.CoreMatchers.anyOf
import static org.hamcrest.CoreMatchers.not
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.collection.IsCollectionContaining.hasItems
import static org.hamcrest.collection.IsCollectionContaining.hasItem

/**
 */
class CollectionAssertions {
    public static def activate() {
        Collection.metaClass.shouldContain = { Object[] args -> assertThat delegate, hasItems(args) }
        Collection.metaClass.shouldNotContain = { Object[] args -> assertThat delegate, notContainAnyOf(args) }
    }

    private static Matcher notContainAnyOf(Object[] args) {
        def elems = args.collect { hasItem(it) }
        not(anyOf(elems))
    }
}
