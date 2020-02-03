package com.bowling.domain.calculator;

import com.bowling.domain.entity.model.GameScore;
import com.bowling.domain.entity.model.Score;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameScoreCalculatorImplTest {

    private Class<? extends GameScoreCalculatorImplTest> thisClass = this.getClass();
    private ObjectMapper mapper = new ObjectMapper();

    private GameScoreCalculator gameScoreCalculator;

    @Before
    public void setUp() {
        gameScoreCalculator = new GameScoreCalculatorImpl();
    }

    @Test
    public void calculateGamesScores() throws IOException {
        Path parsedScoresPath = Paths.get(thisClass.getResource("/parser/game-1-parsed.json").getPath());
        CollectionType scoresListType = mapper.getTypeFactory().constructCollectionType(List.class, Score.class);
        List<List<Score>> parsedScores =
            mapper.readValue(parsedScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, scoresListType));
        List<List<GameScore>> gamesCalculated = gameScoreCalculator.calculateGamesScores(parsedScores);

        Path expectedGameScoresPath = Paths.get(thisClass.getResource("/parser/game-1-calculated.json").getPath());
        CollectionType gameScoresListType = mapper.getTypeFactory().constructCollectionType(List.class, GameScore.class);
        List<List<GameScore>> expectedGameScores =
            mapper.readValue(expectedGameScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, gameScoresListType));
        assertEquals(gamesCalculated, expectedGameScores);
    }

    @Test
    public void calculateGamesScores2() throws IOException {
        Path parsedScoresPath = Paths.get(thisClass.getResource("/parser/game-2-parsed.json").getPath());
        CollectionType scoresListType = mapper.getTypeFactory().constructCollectionType(List.class, Score.class);
        List<List<Score>> parsedScores =
            mapper.readValue(parsedScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, scoresListType));
        List<List<GameScore>> gamesCalculated = gameScoreCalculator.calculateGamesScores(parsedScores);

        Path expectedGameScoresPath = Paths.get(thisClass.getResource("/parser/game-2-calculated.json").getPath());
        CollectionType gameScoresListType = mapper.getTypeFactory().constructCollectionType(List.class, GameScore.class);
        List<List<GameScore>> expectedGameScores =
            mapper.readValue(expectedGameScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, gameScoresListType));
        assertEquals(gamesCalculated, expectedGameScores);
    }

    @Test
    public void calculateGamesScores3() throws IOException {
        Path parsedScoresPath = Paths.get(thisClass.getResource("/parser/game-3-parsed.json").getPath());
        CollectionType scoresListType = mapper.getTypeFactory().constructCollectionType(List.class, Score.class);
        List<List<Score>> parsedScores =
            mapper.readValue(parsedScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, scoresListType));
        List<List<GameScore>> gamesCalculated = gameScoreCalculator.calculateGamesScores(parsedScores);

        Path expectedGameScoresPath = Paths.get(thisClass.getResource("/parser/game-3-calculated.json").getPath());
        CollectionType gameScoresListType = mapper.getTypeFactory().constructCollectionType(List.class, GameScore.class);
        List<List<GameScore>> expectedGameScores =
            mapper.readValue(expectedGameScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, gameScoresListType));
        assertEquals(gamesCalculated, expectedGameScores);
    }

    @Test
    public void calculateGamesScores4() throws IOException {
        Path parsedScoresPath = Paths.get(thisClass.getResource("/parser/game-4-parsed.json").getPath());
        CollectionType scoresListType = mapper.getTypeFactory().constructCollectionType(List.class, Score.class);
        List<List<Score>> parsedScores =
            mapper.readValue(parsedScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, scoresListType));
        List<List<GameScore>> gamesCalculated = gameScoreCalculator.calculateGamesScores(parsedScores);

        Path expectedGameScoresPath = Paths.get(thisClass.getResource("/parser/game-4-calculated.json").getPath());
        CollectionType gameScoresListType = mapper.getTypeFactory().constructCollectionType(List.class, GameScore.class);
        List<List<GameScore>> expectedGameScores =
            mapper.readValue(expectedGameScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, gameScoresListType));
        assertEquals(gamesCalculated, expectedGameScores);
    }

    @Test
    public void calculatePerfectGamesScores() throws IOException {
        Path parsedScoresPath = Paths.get(thisClass.getResource("/parser/perfect-game-parsed.json").getPath());
        CollectionType scoresListType = mapper.getTypeFactory().constructCollectionType(List.class, Score.class);
        List<List<Score>> parsedScores =
                mapper.readValue(parsedScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, scoresListType));
        List<List<GameScore>> gamesCalculated = gameScoreCalculator.calculateGamesScores(parsedScores);

        Path expectedGameScoresPath = Paths.get(thisClass.getResource("/parser/perfect-game-calculated.json").getPath());
        CollectionType gameScoresListType = mapper.getTypeFactory().constructCollectionType(List.class, GameScore.class);
        List<List<GameScore>> expectedGameScores =
                mapper.readValue(expectedGameScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, gameScoresListType));
        assertEquals(gamesCalculated, expectedGameScores);
    }

    @Test
    public void calculateZeroesGameScores() throws IOException {
        Path parsedScoresPath = Paths.get(thisClass.getResource("/parser/zeroes-game-parsed.json").getPath());
        CollectionType scoresListType = mapper.getTypeFactory().constructCollectionType(List.class, Score.class);
        List<List<Score>> parsedScores =
                mapper.readValue(parsedScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, scoresListType));
        List<List<GameScore>> gamesCalculated = gameScoreCalculator.calculateGamesScores(parsedScores);

        Path expectedGameScoresPath = Paths.get(thisClass.getResource("/parser/zeroes-game-calculated.json").getPath());
        CollectionType gameScoresListType = mapper.getTypeFactory().constructCollectionType(List.class, GameScore.class);
        List<List<GameScore>> expectedGameScores =
                mapper.readValue(expectedGameScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, gameScoresListType));
        assertEquals(gamesCalculated, expectedGameScores);
    }
}