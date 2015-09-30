(ns starwars.web.web
  (:require [clj-http.client :as client]))
  
  (def url "http://swapi.co/api/")
  
    (defn find-people [name]
		(if (= name "0") (:body (client/get (str url "people/") {:as :json})) (:body (client/get (str url "people/" name) {:as :json})))
	)

	(defn find-films [name]
		(if (= name "0") (:body (client/get (str url "films/") {:as :json})) (:body (client/get (str url "films/" name) {:as :json})))
	)
		
	(defn find-starship [name]
		(if (= name "0") (:body (client/get (str url "starships/") {:as :json})) (:body (client/get (str url "starships/" name) {:as :json})))
	)

