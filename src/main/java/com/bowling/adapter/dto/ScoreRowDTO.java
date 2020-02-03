package com.bowling.adapter.dto;

import com.bowling.domain.exception.ScoreException;

import java.util.Objects;
import java.util.Optional;

public class ScoreRowDTO {

    private static final String FOUL = "F";

    private String playerName;
    private int score;

    public ScoreRowDTO() {
    }

    public ScoreRowDTO(String playerName, String score) {
        this.playerName = playerName;
        this.score = Optional.of(score)
            .filter(FOUL::equals)
            .map(ignored -> 0)
            .orElseGet(() -> convertScoreToInt(score));
        validateIfNotNegativeScore(this.score);
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    private int convertScoreToInt(String scoreStr) {
        try {
            return Integer.parseInt(scoreStr);
        } catch (NumberFormatException e) {
            throw new ScoreException("Invalid score value for player.", e);
        }
    }

    private void validateIfNotNegativeScore(int score) {
        Optional.of(score)
            .filter(s -> s >= 0)
            .orElseThrow(() -> new ScoreException("Score cannot be a negative number."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreRowDTO that = (ScoreRowDTO) o;
        return score == that.score &&
            Objects.equals(playerName, that.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, score);
    }

    @Override
    public String toString() {
        return "[playerName='" + playerName + "', score=" + score + "]";
    }
}
