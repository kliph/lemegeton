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

(defn all-keys []
  (let [ks (keys data/emojis)
        kws (-> (reduce (fn [acc emoji]
                          (if (:keywords emoji)
                            (apply conj acc (:keywords emoji))
                            acc))
                        #{}
                        (vals data/emojis))
                (into (map name (keys data/emojis))))]
    kws))

(defn levenshtein-distance [s t]
  (let [f (fn [f s t]
            (cond
              (empty? s) (count t)
              (empty? t) (count s)
              :else (let [cost (if (= (first s) (first t))
                                 0
                                 1)]
                      (min (inc (f f (rest s) t))
                           (inc (f f s (rest t)))
                           (+ cost (f f (rest s) (rest t)))))))
        g (memoize f)]
    (g g s t)))

(defn my-main []
  (let [words (classify)
        all-keys (all-keys)
        distances (fn [word] (reduce (fn [acc k]
                                       (let [d (levenshtein-distance word k)
                                             prev-distance (-> acc
                                                               vals
                                                               first)]
                                         (if (zero? prev-distance)
                                           (reduced acc)
                                           (if (< prev-distance d)
                                             acc
                                             (do
                                               (js/console.log k d acc)
                                               (assoc {} k d))))))
                                     {:invalid 1000}
                                     (shuffle all-keys)))]
    (map distances words)))
