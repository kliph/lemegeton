(ns lemegeton.core
  (:require [cljs.nodejs :as nodejs]
            [lemegeton.data :as d]))

(nodejs/enable-util-print!)

(defn -main [& args]
  (println (:char (get d/emojis :candle))))

(set! *main-cli-fn* -main)
