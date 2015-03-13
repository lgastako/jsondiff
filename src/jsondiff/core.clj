(ns jsondiff.core
  (:require [clojure.data :as data]
            [clojure.data.json :as json]))

(defn jsondiff [json1 json2]
  (let [json->edn #(json/read-str % :key-fn keyword)
        edn->json #(json/write-str %)
        edn1 (json->edn json1)
        edn2 (json->edn json2)
        edn-diff (data/diff edn1 edn2)]
    (edn->json edn-diff)))

(defn algorithmia [s]
  (let [json->edn #(json/read-str % :key-fn keyword)
        data (json->edn s)]))
