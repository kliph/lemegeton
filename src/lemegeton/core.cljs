(ns lemegeton.core
  (:require [cljs.nodejs :as nodejs]
            [emojilib]))

(def emojis (js->clj (.-lib emojilib) :keywordize-keys true))
(def ordered (map keyword (.-ordered emojilib)))


(nodejs/enable-util-print!)

(defn -main [& args]
  (println (:char (get emojis :candle))))

(set! *main-cli-fn* -main)
