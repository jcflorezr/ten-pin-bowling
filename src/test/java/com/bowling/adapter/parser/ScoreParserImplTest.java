package com.bowling.adapter.parser;

import com.bowling.domain.entity.model.Score;
import com.bowling.domain.parser.ScoreParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScoreParserImplTest {

    private Class<? extends ScoreParserImplTest> thisClass = this.getClass();
    private ObjectMapper mapper = new ObjectMapper();

    private ScoreParser scoreParser;

    @Before
    public void setUp() {
        scoreParser = new ScoreParserImpl();
    }

    @Test
    public void parseGame1() throws IOException {
        Path scoresPath = Paths.get(thisClass.getResource("/parser/game-1").getPath());
        List<List<Score>> scoresRows = scoreParser.parseScore(scoresPath);
        Path expectedScoresPath = Paths.get(thisClass.getResource("/parser/game-1-parsed.json").getPath());
        CollectionType scoresListType = mapper.getTypeFactory().constructCollectionType(List.class, Score.class);
        List<List<Score>> expectedScoresRows =
            mapper.readValue(expectedScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, scoresListType));
        assertEquals(scoresRows, expectedScoresRows);
    }

    @Test
    public void parseGame2() throws IOException {
        Path scoresPath = Paths.get(thisClass.getResource("/parser/game-2").getPath());
        List<List<Score>> scoresRows = scoreParser.parseScore(scoresPath);
        Path expectedScoresPath = Paths.get(thisClass.getResource("/parser/game-2-parsed.json").getPath());
        CollectionType scoresListType = mapper.getTypeFactory().constructCollectionType(List.class, Score.class);
        List<List<Score>> expectedScoresRows =
            mapper.readValue(expectedScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, scoresListType));
        assertEquals(scoresRows, expectedScoresRows);
    }

    @Test
    public void parseGame3() throws IOException {
        Path scoresPath = Paths.get(thisClass.getResource("/parser/game-3").getPath());
        List<List<Score>> scoresRows = scoreParser.parseScore(scoresPath);
        Path expectedScoresPath = Paths.get(thisClass.getResource("/parser/game-3-parsed.json").getPath());
        CollectionType scoresListType = mapper.getTypeFactory().constructCollectionType(List.class, Score.class);
        List<List<Score>> expectedScoresRows =
            mapper.readValue(expectedScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, scoresListType));
        assertEquals(scoresRows, expectedScoresRows);
    }

    @Test
    public void parseGame4() throws IOException {
        Path scoresPath = Paths.get(thisClass.getResource("/parser/game-4").getPath());
        List<List<Score>> scoresRows = scoreParser.parseScore(scoresPath);
        Path expectedScoresPath = Paths.get(thisClass.getResource("/parser/game-4-parsed.json").getPath());
        CollectionType scoresListType = mapper.getTypeFactory().constructCollectionType(List.class, Score.class);
        List<List<Score>> expectedScoresRows =
            mapper.readValue(expectedScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, scoresListType));
        assertEquals(scoresRows, expectedScoresRows);
    }

    @Test
    public void parsePerfectGame() throws IOException {
        Path scoresPath = Paths.get(thisClass.getResource("/parser/perfect-game").getPath());
        List<List<Score>> scoresRows = scoreParser.parseScore(scoresPath);
        Path expectedScoresPath = Paths.get(thisClass.getResource("/parser/perfect-game-parsed.json").getPath());
        CollectionType scoresListType = mapper.getTypeFactory().constructCollectionType(List.class, Score.class);
        List<List<Score>> expectedScoresRows =
            mapper.readValue(expectedScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, scoresListType));
        assertEquals(scoresRows, expectedScoresRows);
    }

    @Test
    public void parseZeroesGame() throws IOException {
        Path scoresPath = Paths.get(thisClass.getResource("/parser/zeroes-game").getPath());
        List<List<Score>> scoresRows = scoreParser.parseScore(scoresPath);
        Path expectedScoresPath = Paths.get(thisClass.getResource("/parser/zeroes-game-parsed.json").getPath());
        CollectionType scoresListType = mapper.getTypeFactory().constructCollectionType(List.class, Score.class);
        List<List<Score>> expectedScoresRows =
            mapper.readValue(expectedScoresPath.toFile(), mapper.getTypeFactory().constructCollectionType(List.class, scoresListType));
        assertEquals(scoresRows, expectedScoresRows);
    }
}