(ns bracketology.core
  (:require [reagent.core :as r :refer [atom]]))


(enable-console-print!)

(defonce app-state* (atom {:text "Hello FooBar!"
                           :brackets [
                                      [[["goo"
                                         "bar"]
                                        ["biz"
                                         "boz"]]
                                       [["foo"
                                         "biz"]]
                                       [["biz"]]]
                                      [[["soo"
                                         "bar"]
                                        ["biz"
                                         "boz"]]
                                       [["foo"
                                         "biz"]]
                                       [["biz"]]]
                                      [[["hoo"
                                         "bar"]
                                        ["biz"
                                         "boz"]]
                                       [["foo"
                                         "biz"]]
                                       [["biz"]]]
                                      [[["roo"
                                         "bar"]
                                        ["biz"
                                         "boz"]]
                                       [["foo"
                                         "biz"]]
                                       [["biz"]]]
                                      ]}))



(defn game
  [g]
  [:ul.game
   [:li.team (first g)]
   (when (next g)
     [:li.team (last g)])])


(defn bracket
  [games idx]
  (println idx)
  [:ul.col-sm-6
   (for [round (if (even? idx) games (reverse games))]
     ^{:key round}
     [:div.round
      (for [gm round]
        ^{:key gm}
        [game gm])])])


(defn app-view
  [app]
  [:div.container
   [:h1 "Bracket"]
   (for [b (:brackets @app) idx (range (count (:brackets @app)))]
     ^{:key b}
     [bracket b idx])])


(defn main []
  (r/render-component [app-view app-state*]
                      (.getElementById js/document "app")))
