package com.bowling;

import com.bowling.adapter.parser.ScoreParserImpl;
import com.bowling.adapter.printer.GamePrinterImpl;
import com.bowling.application.GameBoardGeneratorImpl;
import com.bowling.domain.calculator.GameScoreCalculator;
import com.bowling.domain.calculator.GameScoreCalculatorImpl;
import com.bowling.domain.parser.ScoreParser;
import com.bowling.domain.printer.GamePrinter;

public class EntryPoint {

    public static void main(String[] args) {
        ScoreParser scoreParser = new ScoreParserImpl();
        GameScoreCalculator gameScoreCalculator = new GameScoreCalculatorImpl();
        GamePrinter gamePrinter = new GamePrinterImpl();

        GameBoardGeneratorImpl gameBoardGenerator = new GameBoardGeneratorImpl(scoreParser, gameScoreCalculator, gamePrinter);
        String board = gameBoardGenerator.generateBoard(args[0]);
        System.out.println(board);
    }
}
