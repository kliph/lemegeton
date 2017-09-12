(ns lemegeton.core
  (:require [cljs.nodejs :as nodejs]
            [lemegeton.classifier :as c]
            [lemegeton.data :as d]))

(nodejs/enable-util-print!)

(defn get-candle []
  (:char (get d/emojis :candle)))

(defn -main [& args]
  (println (c/my-main)))

(set! *main-cli-fn* -main)
