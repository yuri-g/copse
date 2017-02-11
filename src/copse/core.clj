(ns copse.core)

(defn- load-routes [app-ns]
  (println (str "Loading routes from: " app-ns))
  (let [ns (ns-publics app-ns)]
    (((symbol "routes") ns))))

(defn bootstrap [app-namespace]
  (load-routes app-namespace))
