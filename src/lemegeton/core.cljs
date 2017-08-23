(ns lemegeton.core
  (:require [cljs.nodejs :as nodejs]
            [js.hello]))

(nodejs/enable-util-print!)

(defn -main [& args]
  (js.hello/sayHello))

(set! *main-cli-fn* -main)
