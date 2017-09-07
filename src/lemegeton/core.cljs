(ns lemegeton.core
  (:require [cljs.nodejs :as nodejs]
            [lemegeton.data :as d]))

(nodejs/enable-util-print!)

(defn get-candle []
  (:char (get d/emojis :candle)))

(defn -main [& args]
  (println (get-candle)))

(set! *main-cli-fn* -main)
