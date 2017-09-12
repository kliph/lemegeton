(ns lemegeton.runner
  (:require [doo.runner :refer-macros [doo-all-tests]]
            [lemegeton.data-test]
            [lemegeton.classifier-test]))

(doo-all-tests #"(lemegeton)\..*-test")
