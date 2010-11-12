package com.github.tanob.groobe.hamcrest

import com.github.tanob.groobe.AssertionsLoader
import static org.hamcrest.CoreMatchers.not
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.*

class MapAssertions implements AssertionsLoader {

    def void load() {
        Map.metaClass.shouldHaveKey = { assertThat delegate, hasKey(it) }
        Map.metaClass.shouldHaveValue = { assertThat delegate, hasValue(it) }
        Map.metaClass.shouldHaveEntry = { key, value -> assertThat delegate, hasEntry(key, value) }

        Map.metaClass.shouldNotHaveKey = { assertThat delegate, not(hasKey(it)) }
        Map.metaClass.shouldNotHaveValue = { assertThat delegate, not(hasValue(it)) }
        Map.metaClass.shouldNotHaveEntry = { key, value -> assertThat delegate, not(hasEntry(key, value)) }
    }

    def void unload() {
        Map.metaClass = null
    }

}
