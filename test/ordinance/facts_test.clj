(ns ordinance.facts-test
  (:require [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest marseille-has-spec-basis
  (let [sb (facts/spec-basis "marseille")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://mes-demarches.marseille.fr/") sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "paris")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["marseille" "paris"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["paris"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["marseille.arrete-aires-pietonnes-bornes-automatiques-2019"]
         (mapv :ordinance/id (facts/by-topic "marseille" :traffic))))
  (is (empty? (facts/by-topic "marseille" :labor)))
  (is (empty? (facts/by-topic "paris" :public-safety))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/datascript-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
