package com.bowling.domain.exception;

public class FrameException extends ScoreException {

    public FrameException(String message) {
        super(message);
    }

    public static FrameException invalidStrike(String name, int pinFalls) {
        return new FrameException(
            "Invalid Frame. The current frame must be a strike for '" + name + "', " +
            "but it has " + pinFalls + " pinFalls.");
    }

    public static FrameException maxScoreExceeded(String playerName, int score) {
        return new FrameException(
            "Invalid Frame. The current frame for '" + playerName + "' has exceeded the maximum score. Score received: " + score);
    }

    public static FrameException invalidNumOfFrames(String playerName, int numFrames) {
        return new FrameException(
            "Player '" + playerName + "' has " + numFrames + " frames. There must be 10 frames only.");
    }

    public static FrameException missingBonusFrame(String playerName) {
        return new FrameException(
            "Player '" + playerName + "' has no bonus frame after scoring more than 10 points in the 10th frame.");
    }

    public static FrameException existingBonusFrame(String playerName) {
        return new FrameException(
            "Player '" + playerName + "' has been given a bonus frame after scoring less than 10 points in the 10th frame.");
    }
}
