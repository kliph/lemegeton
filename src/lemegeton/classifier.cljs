(ns lemegeton.classifier
  (:require [clojure.string]
            [lemegeton.data :as data]))

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

(defn almost-all-keys []
  (let [ks (keys data/emojis)
        kws (reduce (fn [acc emoji]
                      (if (:keywords emoji)
                        (apply conj acc (:keywords emoji))
                        acc))
                    #{}
                    (vals data/emojis))]
    kws))
