(ns copse.route)

; todo -> extract into another file
(defn GET [path handler]
  {:path path
   :handler handler
   :method :get})

(defn POST [path handler]
  {:path path
   :handler handler
   :method :post})

(defn make-route-key [uri method]
  (keyword (str method ":" uri)))

(defn- add-route [routes current-route]
  (assoc
   routes
   (make-route-key (:path current-route) (:method current-route))
   (:handler current-route)))

(defn def-routes [& route-defenitions]
  (reduce add-route {} route-defenitions))

(defmacro app-routes [& route-defenitions]
  `(defn ~(symbol "routes") []
     (def-routes ~@route-defenitions)))
