(require '[cljs.build.api :as b])

(b/watch "src"
         {:main 'lemegeton.core
          :target :nodejs
          :output-to "main.js"
          :output-dir "out"
          :verbose true
          :foreign-libs [{:file "src"
                          :module-type :es6}]})
