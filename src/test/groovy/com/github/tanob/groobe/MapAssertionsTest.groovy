package com.github.tanob.groobe

import org.junit.Before
import org.junit.Test

class MapAssertionsTest {
    @Before
    public void setUp() {
        GrooBe.activate()
    }

    @Test
    public void testMapShouldHave() {
        def map = [x: 5, y: 6]

        map.shouldHaveKey "y"
        map.shouldHaveValue 6
        map.shouldHaveEntry "x", 5
    }

    @Test
    public void testMapShouldNotHaveKey() {
        def map = [x: 5]

        map.shouldNotHaveKey "y"
    }

    @Test
    public void testMapShouldNotHaveValue() {
        def map = [x: 5]

        map.shouldNotHaveValue 4
    }

    @Test
    public void testMapShouldNotHaveEntry() {
        def map = [x: 5]

        map.shouldNotHaveEntry "y", 5
    }

}
