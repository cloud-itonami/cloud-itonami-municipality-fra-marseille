(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest marseille-has-culture-basis
  (let [sb (facts/spec-basis "marseille")]
    (is (= 9 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "marseille" (:culture/municipality %)) sb))
    (is (every? #(= "FRA" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "paris")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["marseille" "paris"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["paris"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 4 (count (facts/by-kind "marseille" :dish))))
  (is (= ["marseille.beverage.pastis"]
         (mapv :culture/id (facts/by-kind "marseille" :beverage))))
  (is (= ["marseille.craft.santons"]
         (mapv :culture/id (facts/by-kind "marseille" :craft))))
  (is (empty? (facts/by-kind "marseille" :textile)))
  (is (empty? (facts/by-kind "paris" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
