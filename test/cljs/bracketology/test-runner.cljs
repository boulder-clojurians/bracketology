(ns bracketology.test-runner
  (:require
   [cljs.test :refer-macros [run-tests]]
   [bracketology.core-test]))

(enable-console-print!)

(defn runner []
  (if (cljs.test/successful?
       (run-tests
        'bracketology.core-test))
    0
    1))
