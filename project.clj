(defproject wapijure "1.0.0-SNAPSHOT"
  :description "wapijure - a Web API powered by Compojure"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/data.json "0.1.2"]
                 [ring/ring-jetty-adapter "1.1.0"]
                 [compojure "1.0.4"]]
  :plugins [[lein-ring "0.7.0"]]
  :ring {:handler wapijure.web.handler/api}
  :main wapijure.core)

; To just run:
; $ PORT=8080 lein run
;
; To run in development mode (with file reload):
; $ PORT=8080 lein ring server-headless
;
; Or run as standalone app:
; $ lein uberjar
; $ PORT=8080 java -jar target/wapijure-1.0.0-SNAPSHOT-standalone.jar
