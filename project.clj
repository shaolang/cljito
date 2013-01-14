(defproject cljito "0.1.0-SNAPSHOT"
  :description "Mockito wrapper for Clojure"
  :url "https://github.com/shaolang/cljito"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.mockito/mockito-all "1.9.5"]]
  :profiles {:dev {:dependencies [[lazytest "1.2.3"]
                                  [midje "1.4.0"]]
                   :plugins [[lein-midje "2.0.3"]]}})
