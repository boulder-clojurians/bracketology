(ns bracketology.core
  (:require [reagent.core :as r :refer [atom]]))


(enable-console-print!)

(defonce app-state* (atom {:text "Hello FooBar!"
                           :brackets [[[["goo"
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
                                       [["biz"]]]]}))


(defn game
  [g]
  [:ul.game
   [:li.team (first g)]
   (when (next g)
     [:li.team (last g)])])


(defn bracket
  [games idx]
  (js/console.log "idx" idx)
  [:ul.col-sm-6
   (for [round (if (even? idx) games (reverse games))]
     ^{:key round}
     [:div.round
      (for [gm round]
        ^{:key gm}
        [game gm])])])


(defn app-view
  [app]
  (let [i (atom -1)]
    [:div.container
     [:h1 "Bracket"]
     (for [b (:brackets @app)]
       ^{:key b}
       [bracket b (swap! i inc)])]))


(defn main []
  (r/render-component [app-view app-state*]
                      (.getElementById js/document "app")))
