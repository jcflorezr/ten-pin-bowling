package com.bowling.domain.entity.model;

import com.bowling.domain.exception.FrameException;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScoreTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void createStrikeScore() {
        int frame = 1;
        String playerName = "Player Name";
        List<Integer> pinFalls = Arrays.asList(10);

        Score actualScore = new Score(frame, playerName, pinFalls);

        assertEquals(actualScore.getFrame(), frame);
        assertEquals(actualScore.getPlayerName(), playerName);
        assertEquals(actualScore.getPinFalls(), pinFalls);
        assertEquals(actualScore.getNumBonusPinFalls(), 2);
    }

    @Test
    public void createSpareScore() {
        int frame = 1;
        String playerName = "Player Name";
        List<Integer> pinFalls = Arrays.asList(8, 2);

        Score actualScore = new Score(frame, playerName, pinFalls);

        assertEquals(actualScore.getFrame(), frame);
        assertEquals(actualScore.getPlayerName(), playerName);
        assertEquals(actualScore.getPinFalls(), pinFalls);
        assertEquals(actualScore.getNumBonusPinFalls(), 1);
    }

    @Test
    public void createScoreWithoutBonus() {
        int frame = 1;
        String playerName = "Player Name";
        List<Integer> pinFalls = Arrays.asList(1, 3);

        Score actualScore = new Score(frame, playerName, pinFalls);

        assertEquals(actualScore.getFrame(), frame);
        assertEquals(actualScore.getPlayerName(), playerName);
        assertEquals(actualScore.getPinFalls(), pinFalls);
        assertEquals(actualScore.getNumBonusPinFalls(), 0);
    }

    @Test
    public void createScoreForLastFrameWithoutBonusFrame() {
        int frame = 10;
        String playerName = "Player Name";
        List<Integer> pinFalls = Arrays.asList(3, 5);

        Score actualScore = new Score(frame, playerName, pinFalls);

        assertEquals(actualScore.getFrame(), frame);
        assertEquals(actualScore.getPlayerName(), playerName);
        assertEquals(actualScore.getPinFalls(), pinFalls);
        assertEquals(actualScore.getNumBonusPinFalls(), 0);
    }

    @Test
    public void createSpareScoreForLastFrame() {
        int frame = 10;
        String playerName = "Player Name";
        List<Integer> pinFalls = Arrays.asList(3, 7);

        Score actualScore = new Score(frame, playerName, pinFalls);

        assertEquals(actualScore.getFrame(), frame);
        assertEquals(actualScore.getPlayerName(), playerName);
        assertEquals(actualScore.getPinFalls(), pinFalls);
        assertEquals(actualScore.getNumBonusPinFalls(), 1);
    }

    @Test
    public void createStrikeScoreForLastFrame() {
        int frame = 10;
        String playerName = "Player Name";
        List<Integer> pinFalls = Arrays.asList(10, 7);

        Score actualScore = new Score(frame, playerName, pinFalls);

        assertEquals(actualScore.getFrame(), frame);
        assertEquals(actualScore.getPlayerName(), playerName);
        assertEquals(actualScore.getPinFalls(), pinFalls);
        assertEquals(actualScore.getNumBonusPinFalls(), 1);
    }

    @Test
    public void createScoreForBonusFrame() {
        int frame = 11;
        String playerName = "Player Name";
        List<Integer> pinFalls = Arrays.asList(3);

        Score actualScore = new Score(frame, playerName, pinFalls);

        assertEquals(actualScore.getFrame(), frame);
        assertEquals(actualScore.getPlayerName(), playerName);
        assertEquals(actualScore.getPinFalls(), pinFalls);
        assertEquals(actualScore.getNumBonusPinFalls(), 0);
    }

    @Test
    public void createInvalidStrikeScore() {
        String errorMessage = "Invalid Frame. The current frame must be a strike for 'Player Name', " +
            "but it has 8 pinFalls.";
        exceptionRule.expect(FrameException.class);
        exceptionRule.expectMessage(CoreMatchers.equalTo(errorMessage));

        int frame = 1;
        String playerName = "Player Name";
        List<Integer> pinFalls = Arrays.asList(8);

        new Score(frame, playerName, pinFalls);
    }

    @Test
    public void createScoreThatExceedsTheMaximumAllowed() {
        String errorMessage = "Invalid Frame. The current frame for 'Player Name' has exceeded the maximum score. " +
            "Score received: 15";
        exceptionRule.expect(FrameException.class);
        exceptionRule.expectMessage(CoreMatchers.equalTo(errorMessage));

        int frame = 1;
        String playerName = "Player Name";
        List<Integer> pinFalls = Arrays.asList(8, 7);

        new Score(frame, playerName, pinFalls);
    }

    @Test
    public void createScoreThatExceedsTheMaximumAllowedInTheLastFrame() {
        String errorMessage = "Invalid Frame. The current frame for 'Player Name' has exceeded the maximum score. " +
                "Score received: 15";
        exceptionRule.expect(FrameException.class);
        exceptionRule.expectMessage(CoreMatchers.equalTo(errorMessage));

        int frame = 10;
        String playerName = "Player Name";
        List<Integer> pinFalls = Arrays.asList(8, 7);

        new Score(frame, playerName, pinFalls);
    }
}