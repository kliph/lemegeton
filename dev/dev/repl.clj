(ns dev.repl
  (:require [cljs.repl :as repl]
            [figwheel-sidecar.repl-api :as repl-api]
            [cljs.repl.node :as node]))

#_(repl/repl* (node/repl-env)
c
{:watch "src"
             :foreign-libs [{:file "src" :module-type :es6}]})

(defn figwheel-up []
  (do (repl-api/start-figwheel!)
      (repl-api/cljs-repl)))
