package com.solvd.teamgamematch;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ApacheLibrariesMain {
    public static void main(String[] args) {
        final String readPath = "src/main/resources/codeconventions.txt";
        final String writePath = "src/main/resources/result.txt";
        final String[] wordsToCount = new String[]{"Java", "String", "int"};
        final int[] occurrencesOfWords = new int[wordsToCount.length];

        try {
            File readFile = new File(readPath);
            String fileContent = FileUtils.readFileToString(readFile, StandardCharsets.UTF_8);
            countOccurrences(fileContent, wordsToCount, occurrencesOfWords);

            File writeFile = new File(writePath);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < wordsToCount.length; i++) {
                sb.append(wordsToCount[i] + " = " + occurrencesOfWords[i] + System.lineSeparator());
            }
            FileUtils.write(writeFile, sb.toString(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void countOccurrences(String line, String[] wordsToCount, int[] occurrencesOfWords) {
        for (int i = 0; i < wordsToCount.length; i++) {
            occurrencesOfWords[i] += StringUtils.countMatches(line, wordsToCount[i]);
        }
    }
}
