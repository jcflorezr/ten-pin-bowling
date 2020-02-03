package com.bowling.adapter.parser;

import com.bowling.domain.entity.model.Score;
import com.bowling.domain.exception.FrameException;
import com.bowling.domain.parser.ScoreParser;
import com.bowling.domain.exception.ScoreException;
import com.bowling.adapter.dto.ScoreRowDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class ScoreParserImpl implements ScoreParser {

    Map<String, List<List<Integer>>> playersFrames = new LinkedHashMap<>();
    Map<String, Integer> numFramesPerPlayer = new HashMap<>();
    private static final String EOF = "EOF\t0";

    @Override
    public List<List<Score>> parseScore(Path scoresFile) {
        try {
            List<String> lines = Files.readAllLines(scoresFile);
            lines.add(EOF);
            lines.stream()
                .map(line -> line.split("\\t"))
                .map(values -> new ScoreRowDTO(values[0], values[1]))
                .reduce(this::accumulateScores);
            validatePlayersFrames(playersFrames);
            return playersFrames.entrySet().stream()
                .map(entry ->
                    IntStream.range(0, entry.getValue().size())
                        .mapToObj(i -> new Score(i + 1, entry.getKey(), entry.getValue().get(i)))
                        .collect(toList()))
                .collect(toList());
        } catch (IOException e) {
            throw new ScoreException("Error when reading the scores file.", e);
        }
    }

    private ScoreRowDTO accumulateScores(ScoreRowDTO scoreRowDTO1, ScoreRowDTO scoreRowDTO2) {
        if (scoreRowDTO1.getPlayerName() == null) {
            return scoreRowDTO2;
        }
        if (numFramesPerPlayer.containsKey(scoreRowDTO1.getPlayerName())) {
            numFramesPerPlayer.put(scoreRowDTO1.getPlayerName(), numFramesPerPlayer.get(scoreRowDTO1.getPlayerName()) + 1);
        } else {
            numFramesPerPlayer.put(scoreRowDTO1.getPlayerName(), 1);
        }
        List<ScoreRowDTO> scoresDTO;
        if (scoreRowDTO1.getPlayerName().equals(scoreRowDTO2.getPlayerName())) {
            if (scoreRowDTO1.getScore() == 10 && numFramesPerPlayer.get(scoreRowDTO1.getPlayerName()) != 10) {
                scoresDTO = Collections.singletonList(scoreRowDTO1);
            } else {
                scoresDTO = Arrays.asList(scoreRowDTO1, scoreRowDTO2);
            }
        } else {
            scoresDTO = Collections.singletonList(scoreRowDTO1);
        }
        playersFrames.computeIfPresent(
            scoreRowDTO1.getPlayerName(),
            (key, scoresList) -> {
                playersFrames.get(key).add(scoresDTO.stream().map(ScoreRowDTO::getScore).collect(toList()));
                return scoresList;
            });
        playersFrames.putIfAbsent(
            scoreRowDTO1.getPlayerName(),
            initializeScoresListForPlayer(scoresDTO));
        return scoresDTO.size() == 1 ? scoreRowDTO2 : new ScoreRowDTO();
    }

    private void validatePlayersFrames(Map<String, List<List<Integer>>> playerFrames) {
        playerFrames.forEach(this::validatePlayerFrame);
    }

    private void validatePlayerFrame(String playerName, List<List<Integer>> frames) {
        int numFrames = frames.size();
        if (numFrames != 10 && numFrames != 11) {
            throw FrameException.invalidNumOfFrames(playerName, numFrames);
        }
        Integer tenthScore = frames.get(9).stream().reduce(0, Integer::sum);
        if (tenthScore >= 10 && frames.size() < 11) {
            throw FrameException.missingBonusFrame(playerName);
        } else if (tenthScore < 10 && frames.size() > 10) {
            throw FrameException.existingBonusFrame(playerName);
        }
    }

    private List<List<Integer>> initializeScoresListForPlayer(List<ScoreRowDTO> scoresDTO) {
        List<Integer> currentScore = scoresDTO.stream().map(ScoreRowDTO::getScore).collect(toList());
        ArrayList<List<Integer>> scoreList = new ArrayList<>();
        scoreList.add(currentScore);
        return scoreList;
    }
}
