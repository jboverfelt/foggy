(ns foggy.core-test
  (:require [clojure.test :refer :all]
            [foggy.core :refer :all]))

(def paragraph "This has multiple sentences. It's cool! But 
               what does it all mean?")

(deftest words-test
  (testing "basic word splits"
    (is (= (count (words "This has four words.")) 4))))

(deftest sentences-test
    (testing "basic sentence splits"
    (is (= (count (sentences paragraph)) 3))))

(deftest syllables-test
    (testing "basic syllable splits for a word"
    (is (= (count (simple-syllables "parsing")) 2))
    (is (= (count (simple-syllables "pArsInG")) 2))))
