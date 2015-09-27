# Star Wars world

Star Wars application can be used to search Star Wars characters, movies and starships. To use this search, a registered user has to be logged in with his Star Wars account. If a user does not have an account, this application provides a simple registration form.

Application is written in clojure. For search functionality it uses database and REST service of https://swapi.co/ 

## Available pages

* Login and Registration page - initial page where users register, or log in with their existing account
* Home page - Some links to help user navigate arround, and also some basic information, retrieved from DB
* Star Wars characters page - where users can browse through all Star Wars characters and explore their characteristics
* Star Wars movies page - where users can browse through all Star Wars movies and read the intro plot
* Star Wars starships page - where users can browse through all Star Wars starships and explore their characteristics

/access to all pages, except login and registration, is restricted if user is not authenticated.

## Setup

It's necessary to start MongoDB before running the application. Database used in this project is MongoDB 3.0 ( download and install [MongoDB] [1]  ). To start database, open command line, navigate to mongodb/bin folder, and then execute mongod.exe (on Windows). For more detailed instructions on how to start MongoDB, see http://docs.mongodb.org/manual/installation/.

The application automaticaly inserts dummy data in database. If you would like to prevent this comment out the first line in the main method.

Download and install [Leiningen] [2] 1.7.0 or above. To start the application navigate to the root folder and enter: lein run

[1]: https://www.mongodb.org/
[2]: https://github.com/technomancy/leiningen

## Running

There is a default user that you can use, but you can also register with a new account.
    
User:
* username: a
* password: a

## License

Distributed under the Eclipse Public License, the same as Clojure
