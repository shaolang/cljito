(defproject cljito "0.1.0-SNAPSHOT"
  :description "Mockito wrapper for Clojure"
  :url "https://github.com/shaolang/cljito"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles {:dev {:dependencies [[lazytest "1.2.3"]
                                  [midje "1.4.0"]
                                  [org.clojure/clojure "1.4.0"]
                                  [org.mockito/mockito-all "1.9.5"]]
                   :plugins [[lein-midje "2.0.3"]]}
             :1.3 {:dependencies [[org.clojure/clojure "1.3.0"]]}
             :1.5 {:dependencies [[org.clojure/clojure "1.5.0-RC1"]]}
             :mockito-1.8.0 {:dependencies [[org.mockito/mockito-all "1.8.0"]]}
             :mockito-1.9.0 {:dependencies [[org.mockito/mockito-all "1.9.0"]]}}
  :aliases {"all" ["with-profile"
                   "dev:dev,1.3:dev,1.5:dev,mockito-1.8.0:dev,mockito-1.9.0"]})
