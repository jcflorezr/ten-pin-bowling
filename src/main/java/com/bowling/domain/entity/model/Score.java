package com.bowling.domain.entity.model;

import com.bowling.domain.exception.FrameException;

import java.util.List;
import java.util.Objects;

public class Score {

    private int frame;
    private String playerName;
    private List<Integer> pinFalls;
    private int numBonusPinFalls;

    public Score() {
    }

    public Score(int frame, String playerName, List<Integer> pinFalls) {
        this.frame = frame;
        this.playerName = playerName;
        this.pinFalls = validateScore(pinFalls);
        this.numBonusPinFalls = calculateNumBonusPinFalls();
    }

    public int getFrame() {
        return frame;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<Integer> getPinFalls() {
        return pinFalls;
    }

    public int getNumBonusPinFalls() {
        return numBonusPinFalls;
    }

    private List<Integer> validateScore(List<Integer> pinFalls) {
        if (pinFalls.size() == 1 && frame != 11 && pinFalls.get(0) != 10) {
            throw FrameException.invalidStrike(playerName, pinFalls.get(0));
        } else if (pinFalls.size() == 2 && frame != 10 &&
            pinFalls.get(0) + pinFalls.get(1) > 10) {
            throw FrameException.maxScoreExceeded(playerName, pinFalls.get(0) + pinFalls.get(1));
        }
        return pinFalls;
    }

    private int calculateNumBonusPinFalls() {
        if (frame == 11) {
          return 0;
        } else if (frame == 10) {
            return calculateTenthFrameScore();
        } else if (pinFalls.size() == 1) {
            return 2;
        } else if ((pinFalls.get(0) + pinFalls.get(1) == 10)) {
            return 1;
        } else {
            return 0;
        }
    }

    private int calculateTenthFrameScore() {
        int pinFalls1 = pinFalls.get(0);
        int pinFalls2 = pinFalls.get(1);
        int score = pinFalls1 + pinFalls2;
        if (pinFalls1 != 10 && score > 10) {
            throw FrameException.maxScoreExceeded(playerName, score);
        }
        return pinFalls1 == 10 || score == 10 ? 1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return numBonusPinFalls == score.numBonusPinFalls &&
            Objects.equals(playerName, score.playerName) &&
            Objects.equals(pinFalls, score.pinFalls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, pinFalls, numBonusPinFalls);
    }

    @Override
    public String toString() {
        return "Score{" +
                "frame=" + frame +
                ", playerName='" + playerName + '\'' +
                ", pinFalls=" + pinFalls +
                ", numBonusPinFalls=" + numBonusPinFalls +
                '}';
    }
}
