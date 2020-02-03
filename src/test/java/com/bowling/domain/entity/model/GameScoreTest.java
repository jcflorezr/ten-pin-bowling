package com.bowling.domain.entity.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameScoreTest {

    @Test
    public void createGameScore() {
        String playerName = "Player Name";
        int frame = 1;
        List<Integer> pinFalls = Arrays.asList(2, 3);
        int frameScore = 5;

        GameScore gameScore = new GameScore(playerName, frame, pinFalls, frameScore);

        assertEquals(gameScore.getPinFalls().get(0), "2");
        assertEquals(gameScore.getPinFalls().get(1), "3");
    }

    @Test
    public void createSpareGameScore() {
        String playerName = "Player Name";
        int frame = 1;
        List<Integer> pinFalls = Arrays.asList(2, 8);
        int frameScore = 10;

        GameScore gameScore = new GameScore(playerName, frame, pinFalls, frameScore);

        assertEquals(gameScore.getPinFalls().get(0), "2");
        assertEquals(gameScore.getPinFalls().get(1), "/");
    }

    @Test
    public void createStrikeGameScore() {
        String playerName = "Player Name";
        int frame = 1;
        List<Integer> pinFalls = Arrays.asList(10);
        int frameScore = 10;

        GameScore gameScore = new GameScore(playerName, frame, pinFalls, frameScore);

        assertEquals(gameScore.getPinFalls().get(0), "X");
    }

    @Test
    public void createGameScoreForTenthFrame() {
        String playerName = "Player Name";
        int frame = 10;
        List<Integer> pinFalls = Arrays.asList(3, 6);
        int frameScore = 15;

        GameScore gameScore = new GameScore(playerName, frame, pinFalls, frameScore);

        assertEquals(gameScore.getPinFalls().get(0), "3");
        assertEquals(gameScore.getPinFalls().get(1), "6");
        assertEquals(gameScore.getPinFalls().get(2), "6");
    }

    @Test
    public void createSpareGameScoreForTenthFrame() {
        String playerName = "Player Name";
        int frame = 10;
        List<Integer> pinFalls = Arrays.asList(2, 8);
        int frameScore = 20;

        GameScore gameScore = new GameScore(playerName, frame, pinFalls, frameScore);

        assertEquals(gameScore.getPinFalls().get(0), "2");
        assertEquals(gameScore.getPinFalls().get(1), "/");
        assertEquals(gameScore.getPinFalls().get(2), "X");
    }

    @Test
    public void createStrikeGameScoreForTenthFrame() {
        String playerName = "Player Name";
        int frame = 10;
        List<Integer> pinFalls = Arrays.asList(10, 0);
        int frameScore = 19;

        GameScore gameScore = new GameScore(playerName, frame, pinFalls, frameScore);

        assertEquals(gameScore.getPinFalls().get(0), "X");
        assertEquals(gameScore.getPinFalls().get(1), "0");
        assertEquals(gameScore.getPinFalls().get(2), "9");
    }

    @Test
    public void createStrikeGameScoreForTenthFrame2() {
        String playerName = "Player Name";
        int frame = 10;
        List<Integer> pinFalls = Arrays.asList(10, 10);
        int frameScore = 29;

        GameScore gameScore = new GameScore(playerName, frame, pinFalls, frameScore);

        assertEquals(gameScore.getPinFalls().get(0), "X");
        assertEquals(gameScore.getPinFalls().get(1), "X");
        assertEquals(gameScore.getPinFalls().get(2), "9");
    }

    @Test
    public void createStrikeGameScoreForTenthFrame3() {
        String playerName = "Player Name";
        int frame = 10;
        List<Integer> pinFalls = Arrays.asList(10, 10);
        int frameScore = 30;

        GameScore gameScore = new GameScore(playerName, frame, pinFalls, frameScore);

        assertEquals(gameScore.getPinFalls().get(0), "X");
        assertEquals(gameScore.getPinFalls().get(1), "X");
        assertEquals(gameScore.getPinFalls().get(2), "X");
    }
}