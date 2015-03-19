(ns bracketology.core
  (:require [reagent.core :as r :refer [atom]]))


(enable-console-print!)

(defonce app-state* (atom {:text "Hello FooBar!"
                           :brackets [["foo"
                                       "bar"
                                       "biz"
                                       "boz"]
                                      ["aaa"
                                       "bbb"
                                       "ccc"
                                       "ddd"]]}))



(defn bracket
  [teams]
  (println teams)
  [:ul
   (for [team teams]
     [:li.team team])])


(defn app-view
  [app]
  [:div.container
   [:h1 "Bracket"]
   (for [b (:brackets @app)]
     [bracket b])
   ])


(defn main []
  (r/render-component [app-view app-state*]
                      (.getElementById js/document "app")))
