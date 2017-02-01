(ns copse.route)

(defn GET [path handler]
  {:path path
   :handler handler
   :method :get})

(defn POST [path handler]
  {:path path
   :handler handler
   :method :post})

(defn- add-route [routes current-route]
  (println (str "Adding route: " current-route))
  (assoc routes (keyword (str (:method current-route) ":" (:path current-route))) (:handler current-route)))

(defn route [& route-defenitions]
  (println "Defining routes...")
  (reduce {} add-route route-defenitions))

