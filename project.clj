(defproject api-encurtador-url "0.1.0-SNAPSHOT"
  :description "API_ENCURTADOR_URL: Recebe uma url e cria uma versão menor"
  :url "http://localhost:3000/api/url-shortner"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [
    [org.clojure/clojure "1.11.1"]
    [ring "1.10.0"]
    [compojure "1.7.0"]
    [com.datomic/client-cloud "1.0.117"]
  ]
  :main ^:skip-aot api-encurtador-url.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
