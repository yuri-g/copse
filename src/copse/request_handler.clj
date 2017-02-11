(ns copse.request-handler
  (:require [copse.route :refer [make-route-key]]
            [copse.response :as response]))

(defn handler [routes]
  (fn [request]
    (let [{uri :uri method :request-method} request
          key (make-route-key uri method)
          handler (key routes)]
      (if (nil? handler)
        (response/not-found)
        (handler)))))
