(ns cljito.core-test
  (:import [java.util List]
           [org.mockito Mockito])
  (:use midje.sweet
        cljito.core))

(fact "mocks are Mockito mocks"
  (.isMock (Mockito/mockingDetails (mock List))) => true)

(fact "mocks are stubbed, just like Java's"
  (.get (when-> (mock List)
                (.get 0)
                (.thenReturn "it works"))
        0) => "it works"

  (.get (when-> (mock List)
                (.get 0)
                (.thenThrow (classes RuntimeException)))
        0) => (throws RuntimeException))
