package com.bowling.domain.calculator;

import com.bowling.domain.entity.model.GameScore;
import com.bowling.domain.entity.model.Score;

import java.util.List;

public interface GameScoreCalculator {

    List<List<GameScore>> calculateGamesScores(List<List<Score>> games);
}
