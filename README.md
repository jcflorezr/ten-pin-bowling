# Ten-pin Bowling App

This app is implemented following the principles suggested by the [Hexagonal Architecture](https://dzone.com/articles/hexagonal-architecture-what-is-it-and-how-does-it).
This app implements some Java 8 features as Lambda functions, Streams and Optionals.

### Prerequisites to execute it:
* Java 8 must have been installed on the running machine.

### How to execute it: 
* running the main class [com.bowling.EntryPoint.java](https://github.com/jcflorezr/ten-pin-bowling/tree/master/src/main/java/com/bowling/EntryPoint.java) passing the *ABSOLUTE FILE PATH* as argument. An example of absolute path:
    * Unix `/home/user/Documents/folder-containing-scores-file/scores-file`
    * Windows `C:\user\Documents\folder-containing-scores-file\scores-file`
* executing the `./mvnw clean install` command to run all the tests (integration and unit tests).

### Test suite:
* Unit tests:
    * [com.bowling.adapter.dto.ScoreRowDTOTest.java](https://github.com/jcflorezr/ten-pin-bowling/tree/master/src/test/java/com/bowling/adapter/dto/ScoreRowDTO.java)
    * [com.bowling.adapter.parser.ScoreParserImplTest.java](https://github.com/jcflorezr/ten-pin-bowling/tree/master/src/test/java/com/bowling/adapter/parser/ScoreParserImplTest.java)
    * [com.bowling.adapter.printer.GamePrinterImplTest.java](https://github.com/jcflorezr/ten-pin-bowling/tree/master/src/test/java/com/bowling/adapter/printer/GamePrinterImplTest.java)
    * [com.bowling.domain.entity.model.GameScoreTest.java](https://github.com/jcflorezr/ten-pin-bowling/tree/master/src/test/java/com/bowling/domain/entity/model/GameScoreTest.java)
    * [com.bowling.domain.entity.model.ScoreTest.java](https://github.com/jcflorezr/ten-pin-bowling/tree/master/src/test/java/com/bowling/domain/entity/model/ScoreTest.java)
    * [com.bowling.domain.calculator.GameScoreCalculatorImplTest.java](https://github.com/jcflorezr/ten-pin-bowling/tree/master/src/test/java/com/bowling/domain/calculator/GameScoreCalculatorImplTest.java)
* Integration tests:
    * [com.bowling.application.GameBoardGeneratorImplIntegrationTest.java](https://github.com/jcflorezr/ten-pin-bowling/tree/master/src/test/java/com/bowling/application/GameBoardGeneratorImplIntegrationTest.java)