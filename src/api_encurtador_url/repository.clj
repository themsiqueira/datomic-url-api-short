(ns api-encurtador-url.repository
  (:require [datomic.client.api :as d]
            [api-encurtador-url.schema :as schema]
            [api-encurtador-url.db :as conn]))

;; schema already created
;; (defn prepare-database-with-schema []
;;   (d/transact (c/create-connection) {:tx-data url-shorted-schema})
;;   (println "Database prepared successfully."))

(defn save-object [object]
  (let [connection (conn/create-connection)
          tx-data [{:originalUrl (:originalUrl object)
                    :shortedUrl (:shortedUrl object)}]]
    (d/transact connection tx-data)))

(defn get-object-by-shorted-url [shorted-url]
  (let [connection (core/create-connection)
        query '[:find ?e ?originalUrl
                :where
                [?e :shortedUrl ?shortedUrl]
                [?e :originalUrl ?originalUrl]]
        result (d/q query (d/db connection) {:shortedUrl shorted-url})]
    (when (seq result)
      {:id (ffirst result)
       :shortedUrl shorted-url
       :originalUrl (second result)})))