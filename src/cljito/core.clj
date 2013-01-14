(ns cljito.core
  (:import [org.mockito Mockito]))

(defn mock
  "Returns the Mockito-mocked object."
  [klass]
  (Mockito/mock klass))

(defn classes
  "Converts the list of given classes into a Java array,
   especially when Mockito's thenThrow method accepts 
   varargs."
  [& class-list]
  (into-array Class class-list))

(defmacro when->
  "Stubs the given mocked object. Returns the mocked object,
   making it very easy to create mocks in tests. For example:
  
  (when-> (mock List) (.get 0) (.thenThrow (classes RuntimeException)))"
  [mocked action behavior]
  `(-> (Mockito/when (-> ~mocked ~action))
       ~behavior
       (.getMock)))
