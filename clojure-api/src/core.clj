(ns core
  (:require
   [reitit.ring :as ring]
   [ring.adapter.jetty :refer [run-jetty]]))

(def app
  (ring/ring-handler
   (ring/router
    [["/" {:get (fn [_]
                  {:status 200
                   :body "Hello Nakul"})}]

     ["/health" {:get (fn [_]
                        {:status 200
                         :body "OK"})}]

     ["/users" {:get (fn [_]
                       {:status 200
                        :body "[{\"id\":1,\"name\":\"Nakul\"}]"})}]])))

(defn -main []
  (run-jetty app {:port 3000
                  :join? false}))
