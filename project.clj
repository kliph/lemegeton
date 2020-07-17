(defproject lemegeton "0.1.0-SNAPSHOT"
  :description ""
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.773"]
                 [com.cemerick/piggieback "0.2.2"]
                 [lein-doo "0.1.11"]]
  :repl-options {:init-ns dev.repl}
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :clean-targets ^{:protect false} [:target-path "out" "main.js" "test.js"]
  :plugins [[lein-cljsbuild "1.1.6"]
            [lein-doo "0.1.7"]]
  :profiles {:dev {:dependencies [[figwheel-sidecar "0.5.20"]]
                   :source-paths ["src" "dev"]
                   :cljsbuild {:builds [{:id "dev"
                                         :source-paths ["src"]
                                         :figwheel true
                                         :compiler {:main "lemegeton.core"
                                                    :output-to "main.js"
                                                    :output-dir "out"
                                                    :target :nodejs
                                                    :npm-deps {:emojilib "2.2.9"}
                                                    :install-deps false}}
                                        {:id "test"
                                         :source-paths ["src" "test"]
                                         :compiler {:output-to "test.js"
                                                    :output-dir "out"
                                                    :target :nodejs
                                                    :main "lemegeton.runner"}}]}}})
