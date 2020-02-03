package com.bowling.domain.calculator;

import com.bowling.domain.entity.model.GameScore;
import com.bowling.domain.entity.model.Score;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class GameScoreCalculatorImpl implements GameScoreCalculator {

    @Override
    public List<List<GameScore>> calculateGamesScores(List<List<Score>> gamesScores) {
        return gamesScores.stream()
            .map(scores ->
                IntStream.range(0, 10)
                    .mapToObj(i -> createGameScore(i, scores.get(i), scores))
                    .collect(toList())
            ).map(scores ->
                IntStream.range(0, scores.size())
                    .mapToObj(i -> i == 0 ? scores.get(i) : scores.get(i).setFrameScore(scores.get(i - 1).getFrameScore()))
                    .collect(toList()))
                .collect(toList());
    }

    private GameScore createGameScore(int i, Score currentScore, List<Score> scores) {
        Integer currentPinFalls = currentScore.getPinFalls().stream().reduce(0, Integer::sum);
        int gameScore = (i + 1) == scores.size() ? currentPinFalls
            : currentPinFalls + calculateGameScore(i + 1, scores.get(i + 1).getPinFalls(), currentScore.getNumBonusPinFalls(), scores);
        return new GameScore(
            currentScore.getPlayerName(),
            currentScore.getFrame(),
            currentScore.getPinFalls(),
            gameScore);
    }

    private int calculateGameScore(int i, List<Integer> currentPinFalls, int numBonusPinFalls, List<Score> scores) {
        if (numBonusPinFalls == 0) {
            return numBonusPinFalls;
        }
        if (numBonusPinFalls == currentPinFalls.size()) {
            return currentPinFalls.stream().reduce(0, Integer::sum);
        }
        if (numBonusPinFalls < currentPinFalls.size()) {
            return currentPinFalls.get(0);
        }
        return currentPinFalls.get(0) + calculateGameScore(i + 1, scores.get(i + 1).getPinFalls(), numBonusPinFalls - 1, scores);
    }
}
