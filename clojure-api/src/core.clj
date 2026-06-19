(ns core
  (:require
   [reitit.ring :as ring]
   [ring.adapter.jetty :refer [run-jetty]]))

(def app
  (ring/ring-handler
   (ring/router
    [["/" {:get (fn [_]
                  {:status 200
                   :body "Hello World"})}]])))

(defn -main []
  (run-jetty app {:port 3000
                  :join? false}))