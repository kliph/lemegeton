(ns lemegeton.classifier-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [lemegeton.classifier :as c]))

(def test-string "Foo. bar")

(deftest strip-punctuation
  (testing "returns the proper string"
    (is (= "Foo bar"
           (c/strip-punctuation test-string)))))

(deftest word-set
  (testing "returns the proper set"
    (is (= #{"Foo." "bar"}
           (c/word-set test-string)))))
