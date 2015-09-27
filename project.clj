(defproject starwars "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [com.novemberain/monger "1.4.2"]
                 [clj-http "0.7.6"]
                 [enlive "1.1.4"]
                 [ring/ring-jetty-adapter "1.1.6"]
                 [compojure "1.1.3"]
                 [noir "1.3.0"]]
  :main starwars.core)
