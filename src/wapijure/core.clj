(ns wapijure.core
  (:gen-class)
  (:use wapijure.web.api)
  (:require [ring.adapter.jetty :as ring]))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (ring/run-jetty #'wapijure.web.api/app {:port port})))
