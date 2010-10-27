GrooBe
======

`GrooBe` allows you to use should-be assertions on Groovy unit tests. At the moment we support the following:

* Equality assertions
  * `shouldBe` and `shouldNotBe`
  * `shouldEqual` and `shouldNotEqual`
  * `shouldBeEqual` and `shouldNotBeEqual`
  * `shouldBeEqualTo` and `shouldNotBeEqualTo`
  * "instance of" tests with `shouldBeA` and `shouldBeAn`, with the respective `shouldNotBeA` and `shouldNotBeAn`

* Ordering assertions
  * `shouldBeGreaterThan`
  * `shouldBeLessThan`

* String assertions
  * `shouldStartWith` and `shouldNotStartWith`
  * `shouldEndWith` and `shouldNotEndWith`
  * `shouldContain` and `shouldNotContain`

* Map assertions
  * `shouldHaveKey` and `shouldNotHaveKey`
  * `shouldHaveValue` and `shouldNotHaveValue`
  * `shouldHaveEntry` and `shouldNotHaveEntry`

* Collection assertions
  * `shouldContain` and `shouldNotContain`

Examples
--------

You can find several examples in the `GrooBe` tests, but here are some for you:

    (2*2).shouldNotBe 5
    1.shouldBeAn Integer
    "a different string".shouldNotContain "the same string"

Thanks
------

I would like to thank Paul Hammant (http://paulhammant.com/) for all his help and for suggesting the name `GrooBe` for the project.

License
-------

We use a [BSD license](http://en.wikipedia.org/wiki/BSD_licenses) as you can see in our LICENSE.txt.

