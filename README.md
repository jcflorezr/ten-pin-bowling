# Ten-pin Bowling App

### Prerequisites to execute it:
* Java 11 must have been installed on the running machine.
* Docker must have been installed on the running machine as this project implements [TestContainers](https://www.testcontainers.org/) library for running end to end tests and integration tests.


### How to execute it: 
* executing the `./mvnw clean install` command to run all the tests (end to end, integration and unit tests).
* executing the `./mvnw clean spring-boot:run` command to lift up the entire application in order to consume the APIs and the web page available.
* Once the entire app is up and running by executing the previous command:
    * To test the part 1, open a browser and type `http://localhost:8080`.
    * To test the part 2, there is a postman collection attached to this project in the root directory, its name is `zem.postman_collection.json` and it has configured all the requests specified in the test document.


### Test suite:
* Unit tests:
    * [com.test.blog.controller.PortfolioControllerTest.java](https://github.com/jcflorezr/portfolio-app/tree/master/src/test/java/com/test/portfolio/controller/PortfolioControllerTest.java)
    * [com.test.blog.service.PortfolioServiceImplTest.java](https://github.com/jcflorezr/portfolio-app/tree/master/src/test/java/com/test/portfolio/service/PortfolioServiceImplTest.java)
* Integration tests:
    * [com.test.blog.repository.PortfolioRepositoryIntegrationTest.java](https://github.com/jcflorezr/portfolio-app/tree/master/src/test/java/com/test/portfolio/repository/PortfolioRepositoryIntegrationTest.java)
* End to end tests:
    * [com.test.blog.e2e.PortfolioEndToEndTest.java](https://github.com/jcflorezr/portfolio-app/tree/master/src/test/java/com/test/portfolio/e2e/PortfolioEndToEndTest.java) 
