# cljito [![Build Status](https://travis-ci.org/shaolang/cljito.png)](https://travis-ci.org/shaolang/cljito)
cljito is a Mockito wrapper for Clojure. Unlike the other libraries,
cljito aims to be a super-thin wrapper over Mockito, so that
cljito can (hopefully) support Mockito's bells and whistles
with as little changes as possible.

## Usage

In your `project.clj`, add the dev dependencies `[cljito "0.1.0-SNAPSHOT"]`
and `[org.mockito/mockito-all "1.9.5"]`,
and you are all set to start using Mockito in your tests.

The most important function to know is `when->`, the starting point of
most of your mocking needs.

    (import '[java.util List])
    (use 'cljito.core)

    (def mocked (when-> (mock List) (.get 0) (.thenReturn "it works")))
    (.get mocked 0)       ; returns the "it works" string

    (def mocked-2 (mock List))
    (when-> mocked-2 (.get 100) (.thenThrow (classes RuntimeException)))
    (.get mocked-2 100)   ; RuntimeException is thrown

    ; the following four are equivalent
    (verify-> mocked-2 (.get 100))
    (verify-> mocked-2 1 (.get 100))
    (verify-> mocked-2 (times 1) (.get 100))
    (verify-> mocked-2 (Mockito/times 1) (.get 100))

    (verify-> mocked-2 never (.get 0))

    ; the following two are equivalent
    (verify-> mocked-2 (at-least 2) (.get 100)) ; throws AssertionError
    (verify-> mocked-2 (Mockito/atLeast 2) (.get 100))

The code snippet above demonstrates that very little is
cljito specific; `.thenReturn` and `.thenThrow` are really Mockito
methods. Despite that, cljito also provides helper functions (e.g.,
`at-least`, `at-least`, `never`) to make calls to Mockito's static
methods easier.

cljito does not prescribe which version of Mockito you should use;
you must specify Mockito's version in your project.clj dependencies.

For now, cljito is guaranteed to work on Mockito 1.9.5.

## License

Copyright (c) 2013 Shaolang

Distributed under the Eclipse Public License, the same as Clojure.
