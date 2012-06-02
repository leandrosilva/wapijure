(defproject webapijure "1.0.0-SNAPSHOT"
  :description "Webapijure"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [ring/ring-jetty-adapter "1.1.0"]
                 [compojure "1.0.4"]]
  :plugins [[lein-ring "0.7.0"]]
  :ring {:handler webapijure.core/app})

; To run:
; $ PORT=8080 lein run -m webapijure.core
