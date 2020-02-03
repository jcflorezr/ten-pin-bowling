package com.bowling.domain.parser;

import com.bowling.domain.entity.model.Score;

import java.nio.file.Path;
import java.util.List;

public interface ScoreParser {

    List<List<Score>> parseScore(Path scoresFile);

}
