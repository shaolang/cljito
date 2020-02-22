(ns cljito.core
  (:import [org.mockito Mockito]
           [org.mockito.verification VerificationMode]))

(defn mock
  "Returns the Mockito-mocked object."
  [klass]
  (Mockito/mock klass))

(defn spy
  "Returns the Mockito-spied (real) object."
  [obj]
  (Mockito/spy obj))

(defn classes
  "Converts the list of given classes into a Java array,
   especially when Mockito's thenThrow method accepts
   varargs."
  [& class-list]
  (into-array Class class-list))

(defn throwables
  "Converts the list of given throwables into a Java array,
   useful for Mockito methods that expects throwables as varargs."
  [& throwable-list]
  (into-array Throwable throwable-list))

(defmacro when->
  "Stubs the given mocked object. Returns the mocked object,
   making it very easy to create mocks in tests. For example:

  (when-> (mock List) (.get 0) (.thenThrow (classes RuntimeException)))
  (when-> (mock List) (.get 1) (.thenReturn \"first\") (.thenReturn \"second\"))"
  [mocked action & behaviors]
  `(-> (Mockito/when (-> ~mocked ~action))
       ~@behaviors
       (.getMock)))

(defonce never (Mockito/never))
(defn times [n] (Mockito/times n))
(defonce at-least-once (Mockito/atLeastOnce))
(defn at-least [n] (Mockito/atLeast n))
(defn at-most [n] (Mockito/atMost n))

(defn any
  ([] (Mockito/any))
  ([klass] (Mockito/any klass)))

(defn any-boolean       [] (Mockito/anyBoolean))
(defn any-byte          [] (Mockito/anyByte))
(defn any-char          [] (Mockito/anyChar))
(defn any-collection    [] (Mockito/anyCollection))
(defn any-collection-of [klass] (Mockito/anyCollectionOf klass))
(defn any-double        [] (Mockito/anyDouble))
(defn any-float         [] (Mockito/anyFloat))
(defn any-int           [] (Mockito/anyInt))
(defn any-list          [] (Mockito/anyList))
(defn any-list-of       [klass] (Mockito/anyListOf klass))
(defn any-long          [] (Mockito/anyLong))
(defn any-map           [] (Mockito/anyMap))

(defn any-mapOf         [key-class, value-class]
  (Mockito/anyMapOf key-class, value-class))

(defn any-object        [] (Mockito/anyObject))
(defn any-set           [] (Mockito/anySet))
(defn any-set-of        [klass] (Mockito/anySetOf klass))
(defn any-short         [] (Mockito/anyShort))
(defn any-String        [] (Mockito/anyString))
(defn any-vararg        [] (Mockito/anyVararg))

(defmacro verify->
  ([mocked action]
   `(-> (Mockito/verify ~mocked) ~action))
  ([mocked counts action]
   `(let [mode# (if (instance? VerificationMode ~counts)
                    ~counts
                    (times ~counts))]
      (-> (Mockito/verify ~mocked mode#) ~action))))

(defmacro do-* [mock-fn outcome target action]
  `(let [mocked# (-> (. Mockito ~mock-fn ~outcome) ~target)]
     (-> mocked# ~action)
     mocked#))

(defmacro do-return [result target action]
  `(do-* doReturn ~result ~target ~action))

(defmacro do-throw [exception target action]
  `(do-* doThrow ~exception ~target ~action))

(defmacro do-nothing [target action]
  `(let [mocked# (-> (Mockito/doNothing) ~target)]
     (-> mocked# ~action)
     mocked#))
