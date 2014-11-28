(ns interp.core
  (:require [clojure.core.typed :as t]))


(t/defalias AST
  (t/Rec [AST]
         '{:op ':const
           :val t/Any}))


(t/ann analyze [t/Any -> AST])
(defn analyze [syn]
  (cond (number? syn) {:op :const
                       :val syn}
        (keyword? syn) {:op :const
                        :val syn}))


(analyze 1)

(comment
  (t/check-ns))
