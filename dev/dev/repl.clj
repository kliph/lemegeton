(ns dev.repl
  (:require [cljs.repl :as repl]
            [figwheel-sidecar.repl-api :as repl-api]
            [cljs.repl.node :as node]))

(defn figwheel-up []
  (do (repl-api/start-figwheel!)
      (repl-api/cljs-repl)))
