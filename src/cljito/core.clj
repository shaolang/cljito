(ns cljito.core
  (:import [org.mockito Mockito]
           [org.mockito.verification VerificationMode]))

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

(defonce never (Mockito/never))
(defn times [n] (Mockito/times n))
(defonce at-least-once (Mockito/atLeastOnce))
(defn at-least [n] (Mockito/atLeast n))
(defn at-most [n] (Mockito/atMost n))

(defmacro verify->
  ([mocked action]
   `(-> (Mockito/verify ~mocked) ~action))
  ([mocked counts action]
   `(let [mode# (if (instance? VerificationMode ~counts)
                    ~counts
                    (times ~counts))]
      (-> (Mockito/verify ~mocked mode#) ~action))))
