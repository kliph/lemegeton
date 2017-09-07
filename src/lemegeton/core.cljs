(ns lemegeton.core
  (:require [cljs.nodejs :as nodejs]
            [lemegeton.data :as d]
            [clojure.string]))

(nodejs/enable-util-print!)

(def phrase "He appeareth in divers shapes, sometimes like a Cat, sometimes like a Toad, and sometimes like a Man, and sometimes all these forms at once.")

(defn strip-punctuation [s]
  (let [punctuation #"[,.'-]"]
    (clojure.string/replace s punctuation "")))

(defn word-set [s]
  (into #{} (clojure.string/split s #" ")))

(defn classify []
  (-> phrase
      strip-punctuation
      clojure.string/lower-case
      word-set))

(defn get-candle []
  (:char (get d/emojis :candle)))

(defn -main [& args]
  (println (get-candle)))

(set! *main-cli-fn* -main)
