(ns starwars.db.db
  (:require [monger.core :as mg]
            [monger.collection :as mc])
  (:refer-clojure :exclude [sort find])
  (:use monger.query))
  
  (defn login [username password]
  (mg/connect!)
  (mg/set-db!(mg/get-db "starwars"))
  (mc/find-maps "users" {:username username, :password password}))
  
  (defn register [firstname lastname username email password]
  (mg/connect!)
  (mg/set-db!(mg/get-db "starwars"))
  (mc/insert "users" {:firstname firstname, :lastname lastname, :username username, :email email, :password password}))
  
  (defn get-home-data []
  (mg/connect!)
  (mg/set-db!(mg/get-db "starwars"))
  (with-collection "article"
    (find {})
    (fields [:name :shortdesc :desc :image])
    (sort (sorted-map :_id -1))
    (limit 3)))
  
  
  (defn initial-data []
  (mg/connect!)
  (mg/set-db!(mg/get-db "starwars"))
  (mc/insert "article" {:name "Starships", :shortdesc "Informacije o zvezdanim brodovima", :desc "U ovom segmentu se mozete informisati o tome koliko
  je kostala izgradnja jednog ogromnog broda kao sto je Death Star. Mozete istrazivati koliku maksimalnu brzinu moze da postigne koji brod,
  ili koju verziju Hyperdrive-a koristi. Ove i jos neke informaciju su dostupne za 37 razlicitih zvezdanih brodova.", :image "images/starships.png"})
	(mc/insert "article" {:name "Filmovi", :shortdesc "Informacije o Star Wars filmovima", :desc "U ovom dijelu se mogu pronaci informacije
	o tome ko je rezirao film, kada je film premijerno prikazan, kao i kratak uvod, za svih 7 Star Wars filmova.", :image "images/movieposter.jpg"})
	(mc/insert "article" {:name "Likovi", :shortdesc "Informisite se o likovima iz Star Wars univerzuma" :desc "Zanima vas koliko je Master Yoda visok? 
	Ili mozda koliko je Jabba the Hutt tezak? Boja ociju koje se kriju ispod maske Darth Vadera? Istrazujte ove i jos neke karakteristike 
	za preko 80 likova iz SW svijeta...", :image "images/yoda.jpg"})
  (mc/insert "users" {:firstname "Nebojsa", :lastname "Kovac", :username "a", :email "nebojsakovac91@gmail.com", :password "a"}))