# Rick and Morty API Client.

This project is a REST client to consume data from the API-REST https://rickandmortyapi.com/ and return when was
the first appearance of a given character and the name of the episode.

To run this project locally just place the console in the project folder and execute the following command: `./mvnw
spring-boot:run`

To run only the tests execute: `./mvnw test`

To build an image docker place the console in the project folder at same level of Dockerfile and execute the followings
command:  `./mvnw clean compile package` this command compile, test and package the project and
then `docker build . -t rickandmorty-api:latest` to generate the docker image.

If you want build the docker image and run it locally at a once execute: `docker-compose -f docker-compose.yml up -d`
to start and `docker-compose down` to shut down.

Notice that all docker executions need to have docker installed on your system.
