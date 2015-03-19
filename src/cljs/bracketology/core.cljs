(ns bracketology.core
  (:require [reagent.core :as r :refer [atom]]))

(defonce app-state* (atom {:text "Hello Chestnut!"}))


(comment

  (reset! app-state* {:text "FooBar"})


  )

(defn app-view
  [app]
  [:div.container
   [:p (:text @app)]])


(defn main []
  (r/render-component [app-view app-state*]
                      (.getElementById js/document "app")))
