(ns api-encurtador-url.routes
  (:require [compojure.core :refer :all]
            [ring.util.response :refer [response]]
            [compojure.route :as route]
            [api-encurtador-url.handlers :refer [health-check short-url redirect-url]]))

(defroutes app-routes
  (GET "/api/health" [] (health-check))

  (POST "/api/shorten-url" [request] (short-url request))

  (GET "/api/redirect/:id" [id] (redirect-url {:id id}))

  (route/not-found "Not Found"))
