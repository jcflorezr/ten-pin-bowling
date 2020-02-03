package com.bowling.domain.entity.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameScore {

    private String playerName;
    private int frame;
    private List<String> pinFalls;
    private int frameScore;

    public GameScore() {
    }

    public GameScore(String playerName, int frame, List<Integer> pinFalls, int frameScore) {
        this.playerName = playerName;
        this.frame = frame;
        this.frameScore = frameScore;
        this.pinFalls = getPinFallsAsStrings(pinFalls);
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getFrame() {
        return frame;
    }

    public List<String> getPinFalls() {
        return pinFalls;
    }

    public int getFrameScore() {
        return frameScore;
    }

    public GameScore setFrameScore(int previousFrameScore) {
        this.frameScore = frameScore + previousFrameScore;
        return this;
    }

    private List<String> getPinFallsAsStrings(List<Integer> pinFalls) {
        return Optional.of(pinFalls)
            .filter(pinFall -> pinFall.size() == 1)
            .map(this::getSinglePinFalls)
            .orElseGet(() -> getPinFalls(pinFalls));
    }

    private List<String> getSinglePinFalls(List<Integer> pinFalls) {
        return pinFalls.stream()
            .map(pinFall -> pinFall == 10 ? "X" : pinFall.toString())
            .collect(Collectors.toList());
    }

    private List<String> getPinFalls(List<Integer> pinFalls) {
        Integer pinFalls1 = pinFalls.get(0);
        Integer pinFalls2 = pinFalls.get(1);
        int sum = pinFalls1 + pinFalls2;
        boolean tenthFrame = frame == 10;
        String pinFalls1Str = tenthFrame && pinFalls1 == 10 ? "X" : pinFalls1.toString();
        String pinFalls2Str = tenthFrame && pinFalls1 == 10 && pinFalls2 == 10 ? "X"
            : sum == 10 && pinFalls1 < 10 ? "/" : pinFalls2.toString();
        if (tenthFrame) {
            Integer pinFalls3 = frameScore - (pinFalls1 + pinFalls2);
            String pinFalls3Str = pinFalls3 == 10 ? "X" : pinFalls3.toString();
            return Arrays.asList(pinFalls1Str, pinFalls2Str, pinFalls3Str);
        } else {
            return Arrays.asList(pinFalls1Str, pinFalls2Str);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameScore gameScore = (GameScore) o;
        return frame == gameScore.frame &&
            frameScore == gameScore.frameScore &&
            Objects.equals(pinFalls, gameScore.pinFalls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frame, pinFalls, frameScore);
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "playerName='" + playerName + '\'' +
                ", frame=" + frame +
                ", pinFalls=" + pinFalls +
                ", frameScore=" + frameScore +
                '}';
    }
}
