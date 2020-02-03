package com.bowling.application;

import com.bowling.domain.calculator.GameScoreCalculator;
import com.bowling.domain.exception.ScoreException;
import com.bowling.domain.parser.ScoreParser;
import com.bowling.domain.printer.GamePrinter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class GameBoardGeneratorImpl implements GameBoardGenerator {

    private ScoreParser scoreParser;
    private GameScoreCalculator gameScoreCalculator;
    private GamePrinter gamePrinter;

    public GameBoardGeneratorImpl(ScoreParser scoreParser, GameScoreCalculator gameScoreCalculator, GamePrinter gamePrinter) {
        this.scoreParser = scoreParser;
        this.gameScoreCalculator = gameScoreCalculator;
        this.gamePrinter = gamePrinter;
    }

    @Override
    public String generateBoard(String scoresFilePathStr) {
        Path scoresFilePath = Paths.get(scoresFilePathStr);
        return Optional.of(scoreParser.parseScore(scoresFilePath))
            .map(scores -> gameScoreCalculator.calculateGamesScores(scores))
            .map(games -> gamePrinter.printGames(games))
            .orElseThrow(() -> new ScoreException("It was not possible to generate the game board."));
    }
}
