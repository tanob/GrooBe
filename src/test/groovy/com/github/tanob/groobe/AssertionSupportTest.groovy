package com.github.tanob.groobe

import org.junit.Before
import org.junit.Test
import static com.github.tanob.groobe.AssertionSupport.assertWithFailureMessage
import static org.hamcrest.CoreMatchers.equalTo

class AssertionSupportTest {
    @Before
    public void setUp() {
        GrooBe.activate();
    }

    @Test
    public void testAssertionWithLazyFailureMessage() {
        try {
            assertWithFailureMessage false, equalTo(true), { "this will be the failure message" }
        } catch (AssertionError e) {
            e.message.shouldStartWith "this will be the failure message"
        }
    }

    @Test
    public void testThatLazyFailureMessageWillOnlyBeEvaluatedIfMatcherDoesNotMatch() {
        assertWithFailureMessage true, equalTo(true), { throw new Error("this should not be thrown") }
    }
}
