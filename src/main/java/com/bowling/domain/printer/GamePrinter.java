package com.bowling.domain.printer;

import com.bowling.domain.entity.model.GameScore;

import java.util.List;

public interface GamePrinter {

    String printGames(List<List<GameScore>> games);
}
