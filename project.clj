(defproject cljito "0.2.2-SNAPSHOT"
  :description "Mockito wrapper for Clojure"
  :url "https://github.com/shaolang/cljito"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles {:dev {:dependencies [[metosin/testit             "0.4.0"]
                                  [org.clojure/clojure        "1.10.1"]
                                  [org.mockito/mockito-all    "1.9.5"]]}
             :1.3 {:dependencies [[org.clojure/clojure  "1.3.0"]]}
             :1.5 {:dependencies [[org.clojure/clojure  "1.5.0-RC1"]]}}
  :aliases {"all" ["with-profile"
                   "dev:dev,1.3:dev,1.5"]})
