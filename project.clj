(defproject lemegeton "0.1.0-SNAPSHOT"
  :description ""
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :clean-targets ^{:protect false} [:target-path "out"]
  :dependencies [[org.clojure/clojure "1.9.0-alpha16"
                  org.clojure/clojurescript "1.9.908"]]
  :profiles {:dev {:source-paths ["src"]
                   :cljsbuild {:builds [{:id "dev"
                                         :source-paths ["src"]
                                         :compiler {:main "lemegeton.core"
                                                    :output-to "main.js"
                                                    :output-dir "out"
                                                    :optimizations :none
                                                    :target :nodejs
                                                    :foreign-libs [{:file "src/libs/emoji_from_word"
                                                                    :module-type :commonjs}]}
                                         }]}}})
