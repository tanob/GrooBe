package com.github.tanob.groobe.assertions

interface AssertionsLoader {

  public static def assertThat = {String failMessage, boolean result ->
    if (!result) {
      throw new AssertionError(failMessage)
    }
  }

  void load()

  void unload()

}
