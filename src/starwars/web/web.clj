(ns starwars.web.web
  (:require [clj-http.client :as client]))
  
  (def url "http://swapi.co/api/")
  
    (defn find-people [name]
		(:body (client/get (str url "people/" name) {:as :json}))
	)

	(defn find-films [name]
		(:body (client/get (str url "films/" name) {:as :json}))
	)
		
	(defn find-starship [name]
		(:body (client/get (str url "starships/" name) {:as :json}))
	)

