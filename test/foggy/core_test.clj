(ns foggy.core-test
  (:require [clojure.test :refer :all]
            [foggy.core :refer :all]))

(def paragraph "This has multiple sentences. It's cool! But 
               what does it all mean?")

(deftest a-test
  (testing "basic parsing functions"
    (is (= (count (words "This has four words.")) 4))
    (is (= (count (sentences paragraph)) 3))
    (is (= (count (simple-syllables "parsing")) 2))))
