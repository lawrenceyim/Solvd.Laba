package com.solvd.teamgamematch;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

public class ApacheLibrariesMain {
    public static void main(String[] args) {
        String[] wordsToCount = new String[]{"Java", "String", "int"};
        int[] occurrencesOfWords = new int[wordsToCount.length];

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/codeconventions.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                countOccurrences(line, wordsToCount, occurrencesOfWords);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/result.txt"))) {
            for (int i = 0; i < wordsToCount.length; i++) {
                writer.write(wordsToCount[i] + " = " + occurrencesOfWords[i] + System.lineSeparator());
            }
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
