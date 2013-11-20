(ns foggy.core
  (:require [clojure.string :as s]))

(defn words [text]
  (-> text
      (s/replace #"\.|,|;|\?|!" "")
      (s/split #" ")))

(defn sentences [text]
  (re-seq #"\.|!|\?" text))

(defn index [text]
  (let [word-count (count (words text))
        sentence-count (count (sentences text))]
    (/ word-count sentence-count)))

