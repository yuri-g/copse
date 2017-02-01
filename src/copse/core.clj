(ns copse.core
  (:require [clojure.java.io :as io]
            [clojure.inspector :as inspector]))

(defn- load-routes [app]
  (println "Loading routes from:")
  (app/test-test))

(defn bootstrap [app-namespace]
  (load-routes app-namespace))
