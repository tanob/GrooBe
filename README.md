GrooBe
======

`GrooBe` allows you to use should-be assertions on Groovy unit tests. At the moment we support the following:

* Equality assertions
  * `shouldBe` and `shouldNotBe`
  * `shouldEqual` and `shouldNotEqual`
  * `shouldBeEqual` and `shouldNotBeEqual`
  * `shouldBeEqualTo` and `shouldNotBeEqualTo`

* Instance assertions
  * "instance of" tests with `shouldBeA` and `shouldBeAn`, with the respective `shouldNotBeA` and `shouldNotBeAn`

* Comparable assertions
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
  * `shouldBeEmpty` and `shouldNotBeEmpty`

Usage
-----

Just add `GrooBe` as a dependency on your Maven `pom.xml` file:

    <dependency>
        <groupId>com.github.tanob</groupId>
        <artifactId>groobe</artifactId>
        <version>1.0</version>
    </dependency>
 
Example
-------

Being based on the [hamcrest](http://code.google.com/p/hamcrest/) test expressions allows `GrooBe` to be used with JUnit or TestNG.
Here is an example of how you use it with JUnit4, there are several other examples in the `src/test` directory:

    import com.github.tanob.groobe.GrooBe

    import org.junit.Before
    import org.junit.Test

    public class ExampleTest {
        @Before
        public void before() {
            GrooBe.activate()
        }

        @Test
        public void someShouldBeAssertions() {
            (2*2).shouldNotBe 5
            1.shouldBeAn Integer
            "a different string".shouldNotContain "the same string"
        }
    }

Thanks
------

I would like to thank Paul Hammant (http://paulhammant.com/) for all his help and for suggesting the name `GrooBe` for the project.

License
-------

We use a [BSD license](http://en.wikipedia.org/wiki/BSD_licenses) as you can see in our LICENSE.txt.

