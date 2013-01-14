# cljito

cljito is a Mockito wrapper for Clojure.

## Usage

In your `project.clj`, add the dev dependency `[cljito "0.1.0-SNAPSHOT"]`,
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

By default, cljito depends on Mockito 1.9.5.

## License

Copyright (c) 2013 Shaolang

Distributed under the Eclipse Public License, the same as Clojure.
