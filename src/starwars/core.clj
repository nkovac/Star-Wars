(ns starwars.core
 (:require [starwars.db.db :as db]
            [starwars.web.web :as web]
			[starwars.views.views :as views]
            [noir.session :as session]
            [noir.server :as server]
            [noir.core :as noir]
            [noir.response :as response]
            [clojure.java.io :as io]))

			
			(def not-nil? (complement nil?))
			
(defn process-login [username]
 (session/put! :username username) 
 (views/home))
 
(defn check-login [username password]
  (if (nil? (first (db/login username password))) 
    (str "ERROR") 
    (process-login username) 
))  


(noir/defpage [:post "/register"] {:keys [firstname lastname username email password]}
  (db/register firstname lastname username email password)
  (response/redirect "/"))

(noir/defpage [:post "/"] {:keys [username password]}
  (check-login username password))


			
(noir/defpage "/" {}
(session/clear!)
(if (not-nil?  (session/get :username))
	(response/redirect "/home")
  (views/index)))
  
  (noir/defpage "/home.html" {}
  (if (nil?  (session/get :username))
	(response/redirect "/")
  (views/home)))
  
  (noir/defpage "/likovi.html" {}
  (if (nil?  (session/get :username))
	(response/redirect "/")
  (views/likovi "1"))) 
  
  (noir/defpage [:post "/search-people"] {:keys [search]}
  (if (nil?  (session/get :username))
	(response/redirect "/")
  (views/likovi search)))
  
  (noir/defpage "/brodovi.html" {}
  (if (nil?  (session/get :username))
	(response/redirect "/")
  (views/brodovi "9")) )
  
  (noir/defpage [:post "/search-starship"] {:keys [search]}
  (if (nil?  (session/get :username))
	(response/redirect "/")
  (views/brodovi search)))
  
  (noir/defpage "/filmovi.html" {}
  (if (nil?  (session/get :username))
	(response/redirect "/")
  (views/filmovi "1")))
  
  (noir/defpage [:post "/search-films"] {:keys [search]}
  (if (nil?  (session/get :username))
	(response/redirect "/")
  (views/filmovi search)))
  
(defn -main []
  ;;(print (:title (web/find-films "1")))
  ;;(print (:episode_id (web/find-films "1")))
  ;;(print (:opening_crawl (web/find-films "1")))
  ;;(print (:director (web/find-films "1")))
  ;;(print (:producer (web/find-films "1")))
  ;;(print (:release_date (web/find-films "1")))
  ;;(print (:created (web/find-films "1")))
  ;;(print (:edited (web/find-films "1")))
  (db/initial-data)
  (server/start 5949)
  
)

