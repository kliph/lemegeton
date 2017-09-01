(defproject lemegeton "0.1.0-SNAPSHOT"
  :description ""
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha17"]
                 [org.clojure/clojurescript "1.9.908"]
                 [com.cemerick/piggieback "0.2.2"]
                 ]
  :repl-options {:init-ns dev.repl}
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :plugins [[lein-cljsbuild "1.1.6"]]
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src"]
                        :figwheel true
                        :compiler {:main "lemegeton.core"
                                   :output-to "main.js"
                                   :output-dir "out"
                                   :target :nodejs
                                   :foreign-libs [{:file "src"
                                                   :module-type :es6}]}}]})
