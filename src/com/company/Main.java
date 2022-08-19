package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

class Main {
    public static List<String> read(File file) {
        List<String> lines = new ArrayList<>();
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNext()) {
                lines.add(reader.nextLine());
            }
        } catch (FileNotFoundException ignored) {
            System.out.println("File not found");
        }
        return lines;
    }

    public static void main(String[] args) {
        /* File reading */
        System.out.println("What is the path to the file?");
        Scanner scanner = new Scanner(System.in);
        List<String> lines = read(new File(scanner.nextLine()));

        /* Filtering */
        Predicate<String> predicate = s -> Arrays.
                stream(s.split("\\D+")).map(x -> x.isEmpty() ? 0 : Integer.parseInt(x)).
                anyMatch(x -> x >= 10);
        lines.forEach(s -> {
            if (predicate.test(s)) {
                System.out.println(s);
            }
        });
    }
}