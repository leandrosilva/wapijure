(ns webapijure.core
  (:use [compojure.core :only [defroutes GET POST]])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.adapter.jetty :as ring]))

(defroutes main-routes
  (GET "/" [] "<h1>Welcome to Webapijure, a template to build web API based on Compojure.</h1>")
  (route/resources "/")
  (route/not-found "Page not found (403)"))

(def app
  (handler/site main-routes))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (ring/run-jetty #'webapijure.core/app {:port port})))
