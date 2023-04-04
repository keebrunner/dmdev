package com.dmdev.week7.Task1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeCSVFiles {

    public static void main(String[] args) throws IOException {
        Path file1 = Path.of("src","com", "dmdev", "week7", "Task1", "resources", "items-price.csv");
        Path file2 = Path.of("src","com", "dmdev", "week7", "Task1", "resources", "items-name.csv");
        Path resultFile = Path.of("src", "com", "dmdev", "week7", "Task1", "resources", "result.csv");
        Path errorsFile = Path.of("src", "com", "dmdev", "week7", "Task1", "resources", "errors.csv");

        Map<String, String> prices = new HashMap<>();
        try {
            Files.lines(file1)
                    .map(line -> line.split(","))
                    .filter(values -> values.length == 2)
                    .forEach(values -> prices.put(values[0], values[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<String> ids = Stream.concat(
                        Files.lines(file1).map(line -> line.split(",")[0]),
                        Files.lines(file2).map(line -> line.split(",")[0]))
                .collect(Collectors.toSet());

        try (PrintWriter pw = new PrintWriter(new FileWriter(resultFile.toFile()));
             PrintWriter ew = new PrintWriter(new FileWriter(errorsFile.toFile()))) {
            for (String id : ids) {
                String price = prices.get(id);
                try {
                    Files.lines(file2)
                            .map(line -> line.split(","))
                            .filter(values -> values.length == 3 && values[0].equals(id))
                            .forEach(values -> pw.println(id + "," + values[1] + "," + price));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (price == null) {
                    ew.println(id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
