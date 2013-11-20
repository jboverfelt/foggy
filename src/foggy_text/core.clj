(ns foggy.core
  (:require [clojure.string :as s]))

; basic parsing functions

(defn words [text]
  (-> text
      (s/replace #"\.|,|;|\?|!\"'" "")
      (s/split #" ")))

(defn sentences [text]
  (re-seq #"\.|!|\?" text))

(defn simple-syllables
  "This calculates syllables by splitting
   on vowel groupings. NOTE: This will miss several
   special cases in English"
  [word]
  (filter #(not= %1 "") (s/split word #"[^aeiouy]+")))

(defn complex-words
  "Given some text, a function that splits
   a word into a sequence of syllables, and a function
   that splits text into words, return a sequence
   of the words which have greater than or equal to 3 syllables"
  [text syllables words]
  (filter #(> (count (syllables %1)) 3) (words text)))

; default counting and calculation functions

(defn complex-words-count [complex-words]
  (count complex-words))

(defn words-count [words]
  (count words))

(defn sentences-count [sentences]
  (count sentences))

(defn complex-words-percentage [complex-words words]
  (/ complex-words words))

(defn words-per-sentence [words sentences]
  (/ words sentences))

; main functions

(defn fog-index
  "Given the ratio of complex words to words and the
   ratio of words per sentence, calculate the Gunning-Fog index"
  [words-per-sentence complex-words-percentage]
    (* 0.4
       (+ words-per-sentence (* 100 complex-words-percentage))))

(defn basic-fog-score [text]
  (let [complex (complex-words-percentage (complex-words-count (complex-words text simple-syllables words)) (words-count (words text)))
        words-per (words-per-sentence (words-count (words text)) (sentences-count (sentences text)))]
    (fog-index words-per complex)))
