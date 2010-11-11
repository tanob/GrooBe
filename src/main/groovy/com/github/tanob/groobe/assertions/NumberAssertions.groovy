package com.github.tanob.groobe.assertions

class NumberAssertions implements AssertionsLoader {
  private def _shouldBe = {Number expected,
                                 String failMessage = "expecting ${expected}, not ${delegate}" ->
    assertThat(failMessage, delegate == expected)
  }

  void load() {
    Number.metaClass.shouldBe = _shouldBe;
    Number.metaClass.shouldBeEqualsTo = _shouldBe
  }

  void unload() {
    Number.metaClass = null
  }

}
