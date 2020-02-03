package com.bowling.adapter.printer;

import com.bowling.domain.entity.model.GameScore;
import com.bowling.domain.printer.GamePrinter;

import java.util.List;

public class GamePrinterImpl implements GamePrinter {

    private static final String STRIKE = "X";

    @Override
    public String printGames(List<List<GameScore>> games) {

        StringBuilder framePrint = new StringBuilder().append("Frame");
        games.get(0).forEach(game -> framePrint.append("\t").append("\t").append(game.getFrame()));

        StringBuilder gamePrint = new StringBuilder();
        games.forEach(f -> {
            StringBuilder scorePrint = new StringBuilder().append("Score");
            gamePrint.append(f.get(0).getPlayerName()).append("\n")
                .append("PinFalls");
            f.forEach(g -> {
                g.getPinFalls().forEach(p -> {
                    if (STRIKE.equals(p) && g.getFrame() != 10) {
                        gamePrint.append("\t");
                    }
                    gamePrint.append("\t").append(p);
                });
                scorePrint.append("\t").append("\t").append(g.getFrameScore());
            });
            scorePrint.append("\n");
            gamePrint.append("\n").append(scorePrint);
        });

        return framePrint.append("\n").append(gamePrint).toString();
    }
}
