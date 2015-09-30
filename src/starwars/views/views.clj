(ns starwars.views.views
  (:require [net.cgrand.enlive-html :as html]
    		[noir.session :as session]
			[starwars.db.db :as db]
			[starwars.web.web :as web]
    ))
	
	
	(html/deftemplate index "starwars/views/index.html"
	[]
	)
	
	(html/deftemplate home "starwars/views/home.html"
	[]
	[:#slika1] (html/set-attr :src (:image (nth (db/get-home-data) 0)))
    [:#slika2] (html/set-attr :src (:image (nth (db/get-home-data) 1)))
    [:#slika3] (html/set-attr :src (:image (nth (db/get-home-data) 2)))
	
	[:#tekst1] (html/content (:desc (nth (db/get-home-data) 0)))
    [:#tekst2] (html/content (:desc (nth (db/get-home-data) 1)))
    [:#tekst3] (html/content (:desc (nth (db/get-home-data) 2)))
	
	[:#ispodimena1] (html/content (:shortdesc (nth (db/get-home-data) 0)))
    [:#ispodimena2] (html/content (:shortdesc (nth (db/get-home-data) 1)))
    [:#ispodimena3] (html/content (:shortdesc (nth (db/get-home-data) 2)))
	
	[:#ime1] (html/content (:name (nth (db/get-home-data) 0)))
    [:#ime2] (html/content (:name (nth (db/get-home-data) 1)))
    [:#ime3] (html/content (:name (nth (db/get-home-data) 2)))
  )
  (html/deftemplate likovi "starwars/views/likovi.html" [])
  (html/deftemplate filmovi "starwars/views/filmovi.html" [])
  (html/deftemplate brodovi "starwars/views/brodovi.html" [])
  
   (html/deftemplate brodovi "starwars/views/brodovi.html" [search]
   []
   
   (def starship (web/find-starship search))
   
    [:#slika1] (html/set-attr :src (str (str "images/starships/" search) ".jpg"))
	[:#link1] (html/set-attr :href (:url starship))
	[:#ime1] (html/content (:name starship))
	[:#ispodimena1] (html/content (:model starship))
	[:#proizvodjac] (html/content (:manufacturer starship))
	[:#cijena] (html/content (:cost_in_credits starship))
	[:#duzina] (html/content (:length starship))
	[:#brzina] (html/content (:max_atmosphering_speed starship))
	[:#posada] (html/content (:crew starship))
	[:#putnici] (html/content (:passengers starship))
	[:#skladiste] (html/content (:cargo_capacity starship))
	[:#zalihe] (html/content (:consumables starship))
	[:#hiperdrive] (html/content (:hyperdrive_rating starship))
	[:#mglt] (html/content (:MGLT starship))
	[:#klasa] (html/content (:starship_class starship))
	[:#kreiran] (html/content (:created starship))
	[:#editovan] (html/content (:edited starship))

  
   
   )
   
   (html/deftemplate filmovi "starwars/views/filmovi.html" [search]
   []
   (def film (web/find-films search))
   
    [:#slika1] (html/set-attr :src (str (str "images/films/" search) ".jpg"))
    [:#link1] (html/set-attr :href (:url film))
    [:#ime1] (html/content (:title film))
	[:#uvod] (html/content (:opening_crawl film))
    [:#reziser] (html/content (:director film))
	[:#producent] (html/content (:producer film))
	[:#premijera] (html/content (:release_date film))
	;; TODO: Povezati sa drugim stranama
	
   )
   
  (html/deftemplate likovi "starwars/views/likovi.html" [search]
  []
  (def lik (web/find-people search))
  
  [:#slika1] (html/set-attr :src (str (str "images/people/" search) ".jpg"))
  [:#link1] (html/set-attr :href (:url lik))
  [:#ime1] (html/content (:name lik))
  [:#ispodimena1] (html/content (:gender lik))
  [:#visina] (html/content (:height lik))
  [:#masa] (html/content (:mass lik))
  [:#kosa] (html/content (:hair_color lik))
  [:#koza] (html/content (:skin_color lik))
  [:#oci] (html/content (:eye_color lik))
  [:#godina] (html/content (:birth_year lik))
  [:#kreiran] (html/content (:created lik))
  [:#editovan] (html/content (:edited lik))
  [:#filmvalue1] (html/set-attr :value (subs (get (:films lik) 0) 26 27))
  [:#starshipvalue1] (html/set-attr :value (subs (get (:starships lik) 0) 30 32))
  ;; TODO: Refaktorisati ovo da bude stabilnije...
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  )