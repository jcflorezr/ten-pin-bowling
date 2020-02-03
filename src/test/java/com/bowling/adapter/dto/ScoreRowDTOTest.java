package com.bowling.adapter.dto;

import com.bowling.domain.exception.ScoreException;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ScoreRowDTOTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void getScoreDTO() {
        String playerName = "Player Name";
        String score = "10";

        ScoreRowDTO actualScoreRowDTO = new ScoreRowDTO(playerName, score);

        assertEquals(actualScoreRowDTO.getPlayerName(), playerName);
        assertEquals(actualScoreRowDTO.getScore(), Integer.parseInt(score));
    }

    @Test
    public void getFoulScoreDTO() {
        String playerName = "Player Name";
        String score = "F";

        ScoreRowDTO actualScoreRowDTO = new ScoreRowDTO(playerName, score);

        assertEquals(actualScoreRowDTO.getPlayerName(), playerName);
        assertEquals(actualScoreRowDTO.getScore(), 0);
    }

    @Test
    public void shouldThrowInvalidScoreValueError() {
        exceptionRule.expect(ScoreException.class);
        exceptionRule.expectMessage(CoreMatchers.equalTo("Invalid score value for player."));

        String playerName = "Player Name";
        String score = "R";

        new ScoreRowDTO(playerName, score);
    }

    @Test
    public void shouldThrowNegativeNumberScoreError() {
        exceptionRule.expect(ScoreException.class);
        exceptionRule.expectMessage(CoreMatchers.equalTo("Score cannot be a negative number."));

        String playerName = "Player Name";
        String score = "-1";

        new ScoreRowDTO(playerName, score);
    }

}