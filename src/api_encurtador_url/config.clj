(ns api-encurtador-url.config
  (:require [ring.adapter.jetty :as jetty]
  ;; [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            ))

;; (defn wrap-middlewares [app-routes]
;;   (-> app-routes
;;       (wrap-json-body app-routes {:keywords? true})
;;       (wrap-json-response)))

(defn start-server [app-routes]
  (jetty/run-jetty app-routes {:port 3000}))
