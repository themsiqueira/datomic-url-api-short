(ns api-encurtador-url.db
  (:require [datomic.client.api :as d]))

(def cfg {
  :server-type :ion
  :region "us-east-1"
  :system "datomic-functional"
  :creds-profile "default"
  :endpoint "https://hfrx18nzsi.execute-api.us-east-1.amazonaws.com"
})

(defn create-connection []
  (let [client (d/client cfg)]
    ;; database ja criado
    ;; (d/create-database client {:db-name "api-encurtador-url"})
    (d/connect client {:db-name "api-encurtador-url"})))

(def conn (create-connection))