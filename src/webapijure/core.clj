(ns webapijure.core
  (:use [clojure.data.json :only (json-str)])
  (:use [compojure.core :only [defroutes GET POST]])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.adapter.jetty :as ring]))

(defroutes main-routes
  (GET "/" []
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (json-str {"info" "A template to build web API based on Compojure"})})

  (POST "/hello/:name" [name]
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (json-str {"hello" name})})

  (route/resources "/")
  (route/not-found "Page not found (403)"))

(def app
  (handler/site main-routes))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (ring/run-jetty #'webapijure.core/app {:port port})))
