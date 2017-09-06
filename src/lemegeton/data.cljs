(ns lemegeton.data
  (:require [cljs.nodejs :as nodejs]))

(defn node-slurp [path]
  (let [fs (nodejs/require "fs")]
    (.readFileSync fs path "utf8")))

(defn parse-json [json & opts]
  (let [parsed-json (.parse js/JSON json)]
       (apply js->clj parsed-json opts)))

(defonce emojis-path "src/data/emojis.json")

(defonce emojis-json (node-slurp emojis-path))

(defonce emojis
  (parse-json emojis-json :keywordize-keys true))
