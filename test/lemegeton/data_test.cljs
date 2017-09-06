(ns lemegeton.data-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [lemegeton.data :as data]))

(def test-file-path "test/data/foo.json")

(deftest reading-json-file
  (testing "returns a string"
    (is (string? (data/node-slurp test-file-path)))))
(deftest parsing-json
  (testing "has the correct data"
    (is (= "bar"
           (-> test-file-path
               data/node-slurp
               data/parse-json
               (get "foo")))))
  (testing "accepts opts"
    (is (= "bar"
           (-> test-file-path
               data/node-slurp
               (data/parse-json :keywordize-keys true)
               (get :foo))))))
