(ns wapijure.core
  (:gen-class)
  (:use wapijure.web.handler)
  (:require [ring.adapter.jetty :as ring]))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (ring/run-jetty #'wapijure.web.handler/api {:port port})))
