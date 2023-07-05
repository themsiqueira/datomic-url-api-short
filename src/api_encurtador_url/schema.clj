(ns api-encurtador-url.schema)

(def url-shorted-schema
  [{:db/ident :originalUrl
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/fulltext true}
   {:db/ident :shortedUrl
    :db/valueType :db.type/string
    :db/cardinality :db.cardinality/one
    :db/fulltext true}])
