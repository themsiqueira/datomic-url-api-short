(ns api-encurtador-url.core
  (:require [api-encurtador-url.config :refer [start-server]]
            [api-encurtador-url.routes :refer [app-routes]]))

(def app
  (start-server app-routes))
