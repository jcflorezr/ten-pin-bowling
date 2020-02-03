package com.bowling.application;

import com.bowling.adapter.parser.ScoreParserImpl;
import com.bowling.adapter.printer.GamePrinterImpl;
import com.bowling.domain.calculator.GameScoreCalculatorImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class GameBoardGeneratorImplIntegrationTest {

    private Class<? extends GameBoardGeneratorImplIntegrationTest> thisClass = this.getClass();

    private GameBoardGenerator gameBoardGenerator;

    @Before
    public void setUp() {
        gameBoardGenerator =
            new GameBoardGeneratorImpl(new ScoreParserImpl(), new GameScoreCalculatorImpl(), new GamePrinterImpl());
    }

    @Test
    public void generateGamesBoard1() throws IOException {
        String gamesPath = thisClass.getResource("/parser/game-1").getPath();
        String actualPrintedGame = gameBoardGenerator.generateBoard(gamesPath);
        Path printedGamesPath = Paths.get(thisClass.getResource("/parser/game-1-printed").getPath());
        String expectedPrintedGame = Files.readAllLines(printedGamesPath).stream()
            .reduce("", (s1, s2) -> s1 + s2+ "\n");

        assertEquals(actualPrintedGame, expectedPrintedGame);
    }

    @Test
    public void generateGamesBoard2() throws IOException {
        String gamesPath = thisClass.getResource("/parser/game-2").getPath();
        String actualPrintedGame = gameBoardGenerator.generateBoard(gamesPath);
        Path printedGamesPath = Paths.get(thisClass.getResource("/parser/game-2-printed").getPath());
        String expectedPrintedGame = Files.readAllLines(printedGamesPath).stream()
                .reduce("", (s1, s2) -> s1 + s2+ "\n");

        assertEquals(actualPrintedGame, expectedPrintedGame);
    }

    @Test
    public void generateGamesBoard3() throws IOException {
        String gamesPath = thisClass.getResource("/parser/game-4").getPath();
        String actualPrintedGame = gameBoardGenerator.generateBoard(gamesPath);
        Path printedGamesPath = Paths.get(thisClass.getResource("/parser/game-4-printed").getPath());
        String expectedPrintedGame = Files.readAllLines(printedGamesPath).stream()
                .reduce("", (s1, s2) -> s1 + s2+ "\n");

        assertEquals(actualPrintedGame, expectedPrintedGame);
    }

    @Test
    public void generateGamesBoardWithThreePlayers() throws IOException {
        String gamesPath = thisClass.getResource("/parser/game-3").getPath();
        String actualPrintedGame = gameBoardGenerator.generateBoard(gamesPath);
        Path printedGamesPath = Paths.get(thisClass.getResource("/parser/game-3-printed").getPath());
        String expectedPrintedGame = Files.readAllLines(printedGamesPath).stream()
            .reduce("", (s1, s2) -> s1 + s2+ "\n");

        assertEquals(actualPrintedGame, expectedPrintedGame);
    }

    @Test
    public void generatePerfectGameBoard() throws IOException {
        String gamesPath = thisClass.getResource("/parser/perfect-game").getPath();
        String actualPrintedGame = gameBoardGenerator.generateBoard(gamesPath);

        Path printedGamesPath = Paths.get(thisClass.getResource("/parser/perfect-game-printed").getPath());
        String expectedPrintedGame = Files.readAllLines(printedGamesPath).stream()
            .reduce("", (s1, s2) -> s1 + s2+ "\n");

        assertEquals(actualPrintedGame, expectedPrintedGame);
    }

    @Test
    public void generateZeroesGameBoard() throws IOException {
        String gamesPath = thisClass.getResource("/parser/zeroes-game").getPath();
        String actualPrintedGame = gameBoardGenerator.generateBoard(gamesPath);

        Path printedGamesPath = Paths.get(thisClass.getResource("/parser/zeroes-game-printed").getPath());
        String expectedPrintedGame = Files.readAllLines(printedGamesPath).stream()
                .reduce("", (s1, s2) -> s1 + s2+ "\n");

        assertEquals(actualPrintedGame, expectedPrintedGame);
    }
}