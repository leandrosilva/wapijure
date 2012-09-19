(ns wapijure.web.api
  (:use [clojure.data.json :only (json-str)])
  (:use [compojure.core :only [defroutes GET POST]])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.adapter.jetty :as ring]))

(defroutes main-routes
  ; curl -X GET http://localhost:8080/
  (GET "/" []
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (json-str {"info" "A template to build web API based on Compojure"})})

  ; curl -X GET http://localhost:8080/hello/world
  (GET "/hello/:name" [name]
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (json-str {"hello" name})})

  ; curl -X POST http://localhost:8080/echo -d 'text=Awesome, baby!'
  (POST "/echo" [text]
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (json-str {"text" text})})

  (route/resources "/")
  (route/not-found "Page not found (404)"))

(def app
  (handler/site main-routes))
