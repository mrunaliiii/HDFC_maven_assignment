package com.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyAnalyzer {
    public static void main(String[] args) {
        try {
            // Input and Output Paths
            //Path inputPath = Paths.get("src/main/resources/input.txt");
            Path outputDir = Paths.get("target/output");
            Path outputFile = outputDir.resolve("output.txt");

            // Read file
            //String content = Files.readString(inputPath);

            InputStream inputStream = WordFrequencyAnalyzer.class.getClassLoader().getResourceAsStream("input.txt");

            if (inputStream == null) {
                System.err.println("input.txt not found in resources!");
                return;
            }

            String content = new String(inputStream.readAllBytes());
            // Process words: lowercase, remove punctuation
            String[] words = content.toLowerCase()
                    .replaceAll("[^a-z0-9\\s]", " ")
                    .split("\\s+");

            // Count frequency
            Map<String, Integer> wordCount = new HashMap<>();
            for (String word : words) {
                if (!word.isBlank()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

            // Sort by frequency (descending), then word (ascending)
            List<Map.Entry<String, Integer>> sortedList = wordCount.entrySet()
                    .stream()
                    .sorted((a, b) -> {
                        int cmp = b.getValue().compareTo(a.getValue());
                        return cmp != 0 ? cmp : a.getKey().compareTo(b.getKey());
                    })
                    .collect(Collectors.toList());

            // Ensure output directory exists
            Files.createDirectories(outputDir);

            // Write to file
            try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
                for (Map.Entry<String, Integer> entry : sortedList) {
                    writer.write(entry.getKey() + " : " + entry.getValue());
                    writer.newLine();
                }
            }

            System.out.println("Word frequency analysis complete! Check " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
