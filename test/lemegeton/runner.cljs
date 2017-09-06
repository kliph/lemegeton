(ns lemegeton.runner
  (:require [doo.runner :refer-macros [doo-all-tests]]
            [lemegeton.data-test]))

(doo-all-tests #"(lemegeton)\..*-test")
