(defproject cljito "0.3.0-SNAPSHOT"
  :description "Mockito wrapper for Clojure"
  :url "https://github.com/shaolang/cljito"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :profiles {:dev {:dependencies [[bultitude "0.2.0"]
                                  [midje "1.5.1"]
                                  [org.clojure/clojure "1.5.1"]
                                  [org.mockito/mockito-all "1.9.5"]]
                   :plugins [[lein-midje "3.0.1"]]}
             :1.3 {:dependencies [[org.clojure/clojure "1.3.0"]]}
             :1.4 {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.5 {:dependencies [[org.clojure/clojure "1.5.0"]]}}
  :aliases {"all" ["with-profile"
                   "dev:dev,1.3:dev,1.4:dev,1.5"]})
