(ns copse.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [copse.request-handler :refer [handler]]))

(defn- preload-routes [app-ns]
  (let [ns (ns-publics app-ns)
        routes-function ((symbol "routes") ns)]
    (if (nil? routes-function)
      (println "Routes function not defined in http/routes.clj")
      (routes-function))))

(defn bootstrap [app-namespace]
  (run-jetty
   (handler (preload-routes app-namespace))
   {:port 3001}))

