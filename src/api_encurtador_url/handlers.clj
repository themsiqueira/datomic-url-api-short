(ns api-encurtador-url.handlers
  (:require [api-encurtador-url.repository :as repo]
            [ring.util.response :as response]))

(defn health-check [] "OK!")

(defn short-url [request]
  (let [uuid (java.util.UUID/randomUUID)
        ;; essa url pode ser qualquer uma, desde que seja a mesma que está rodando api
        shorted-url (str "http://localhost:3000/api/redirect/" uuid)
        object (assoc (:params request)
                                      :originalUrl (:url (:params request))
                                      :shortedUrl shorted-url)]
    (repo/save-object object)
    object))

(defn redirect-url [request]
  (let [object (repo/get-object-by-shorted-url (str "http://localhost:3000/api/redirect/" (:id (:params request))))]
    (if object
      (response/redirect (:originalUrl object))
      (response/not-found "URL not found."))))
