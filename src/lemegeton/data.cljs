(ns lemegeton.data
  (:require [cljs.nodejs :as nodejs]))

(defn node-slurp [path]
  (let [fs (nodejs/require "fs")]
    (.readFileSync fs path "utf8")))

(defonce emojis-path "src/data/emojis.json")

(defonce emojis-json (node-slurp emojis-path))

(defonce emojis
  (-> (.parse js/JSON emojis-json)
      (js->clj :keywordize-keys true)))
