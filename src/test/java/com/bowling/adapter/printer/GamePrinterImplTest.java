package com.bowling.adapter.printer;

import com.bowling.domain.entity.model.GameScore;
import com.bowling.domain.printer.GamePrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GamePrinterImplTest {

    private Class<? extends GamePrinterImplTest> thisClass = this.getClass();
    private ObjectMapper mapper = new ObjectMapper();

    private GamePrinter gamePrinter;

    @Before
    public void setUp() {
        gamePrinter = new GamePrinterImpl();
    }

    @Test
    public void printGames1() throws IOException {
        Path gamesScoresPath = Paths.get(thisClass.getResource("/parser/game-1-calculated.json").getPath());
        CollectionType gamesScoresListType = mapper.getTypeFactory().constructCollectionType(List.class, GameScore.class);
        List<List<GameScore>> gamesScores =
            mapper.readValue(gamesScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, gamesScoresListType));

        String actualPrintedGame = gamePrinter.printGames(gamesScores);
        Path printedGamesPath = Paths.get(thisClass.getResource("/parser/game-1-printed").getPath());
        String expectedPrintedGame = Files.readAllLines(printedGamesPath).stream()
                .reduce("", (s1, s2) -> s1 + s2+ "\n");

        assertEquals(actualPrintedGame, expectedPrintedGame);
    }

    @Test
    public void printGames2() throws IOException {
        Path gamesScoresPath = Paths.get(thisClass.getResource("/parser/game-2-calculated.json").getPath());
        CollectionType gamesScoresListType = mapper.getTypeFactory().constructCollectionType(List.class, GameScore.class);
        List<List<GameScore>> gamesScores =
                mapper.readValue(gamesScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, gamesScoresListType));

        String actualPrintedGame = gamePrinter.printGames(gamesScores);
        Path printedGamesPath = Paths.get(thisClass.getResource("/parser/game-2-printed").getPath());
        String expectedPrintedGame = Files.readAllLines(printedGamesPath).stream()
                .reduce("", (s1, s2) -> s1 + s2+ "\n");

        assertEquals(actualPrintedGame, expectedPrintedGame);
    }

    @Test
    public void printGames3() throws IOException {
        Path gamesScoresPath = Paths.get(thisClass.getResource("/parser/game-3-calculated.json").getPath());
        CollectionType gamesScoresListType = mapper.getTypeFactory().constructCollectionType(List.class, GameScore.class);
        List<List<GameScore>> gamesScores =
                mapper.readValue(gamesScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, gamesScoresListType));

        String actualPrintedGame = gamePrinter.printGames(gamesScores);
        Path printedGamesPath = Paths.get(thisClass.getResource("/parser/game-3-printed").getPath());
        String expectedPrintedGame = Files.readAllLines(printedGamesPath).stream()
                .reduce("", (s1, s2) -> s1 + s2+ "\n");

        assertEquals(actualPrintedGame, expectedPrintedGame);
    }

    @Test
    public void printGames4() throws IOException {
        Path gamesScoresPath = Paths.get(thisClass.getResource("/parser/game-4-calculated.json").getPath());
        CollectionType gamesScoresListType = mapper.getTypeFactory().constructCollectionType(List.class, GameScore.class);
        List<List<GameScore>> gamesScores =
                mapper.readValue(gamesScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, gamesScoresListType));

        String actualPrintedGame = gamePrinter.printGames(gamesScores);
        Path printedGamesPath = Paths.get(thisClass.getResource("/parser/game-4-printed").getPath());
        String expectedPrintedGame = Files.readAllLines(printedGamesPath).stream()
                .reduce("", (s1, s2) -> s1 + s2+ "\n");

        assertEquals(actualPrintedGame, expectedPrintedGame);
    }

    @Test
    public void printPerfectGame() throws IOException {
        Path gamesScoresPath = Paths.get(thisClass.getResource("/parser/perfect-game-calculated.json").getPath());
        CollectionType gamesScoresListType = mapper.getTypeFactory().constructCollectionType(List.class, GameScore.class);
        List<List<GameScore>> gamesScores =
            mapper.readValue(gamesScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, gamesScoresListType));

        String actualPrintedGame = gamePrinter.printGames(gamesScores);

        Path printedGamesPath = Paths.get(thisClass.getResource("/parser/perfect-game-printed").getPath());
        String expectedPrintedGame = Files.readAllLines(printedGamesPath).stream()
            .reduce("", (s1, s2) -> s1 + s2+ "\n");

        assertEquals(actualPrintedGame, expectedPrintedGame);
    }

    @Test
    public void printZeroesGame() throws IOException {
        Path gamesScoresPath = Paths.get(thisClass.getResource("/parser/zeroes-game-calculated.json").getPath());
        CollectionType gamesScoresListType = mapper.getTypeFactory().constructCollectionType(List.class, GameScore.class);
        List<List<GameScore>> gamesScores =
            mapper.readValue(gamesScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, gamesScoresListType));

        String actualPrintedGame = gamePrinter.printGames(gamesScores);

        Path printedGamesPath = Paths.get(thisClass.getResource("/parser/zeroes-game-printed").getPath());
        String expectedPrintedGame = Files.readAllLines(printedGamesPath).stream()
            .reduce("", (s1, s2) -> s1 + s2+ "\n");

        assertEquals(actualPrintedGame, expectedPrintedGame);
    }
}