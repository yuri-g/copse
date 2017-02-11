(ns copse.response)

(defn make-response
  ([code]
   (make-response code nil))

  ([code body]
   {:status code :body body}))

(defn not-found []
  (make-response 404 "Not found"))
