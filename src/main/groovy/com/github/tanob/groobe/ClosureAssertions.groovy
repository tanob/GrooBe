package com.github.tanob.groobe

import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.CoreMatchers.equalTo

/**
 */
class ClosureAssertions {
    public static def activate() {
        Closure.metaClass.shouldFailWith = { expectedException, expectedExceptionMessage = null ->
            boolean completed = false
            try {
                delegate.doCall()
                completed = true
            } catch (Throwable throwable) {
                assertThrowable(throwable, expectedException, expectedExceptionMessage)
            }

            if (completed) {
                throw new AssertionError(String.format("Expected exception <%s> was not thrown",
                        expectedException))
            }
        }
    }

    private static def assertThrowable(Throwable throwable, expectedException, expectedExceptionMessage) {
        assertThat throwable.getClass(), equalTo(expectedException)

        if (expectedExceptionMessage) {
            assertThat throwable.getMessage(), equalTo(expectedExceptionMessage)
        }
    }
}
