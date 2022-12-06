package at.gruber.dev.y2015;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Day03 {
    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get("D:\\Daten\\Dokumente\\IntellijProjects\\AdventOfCode\\src\\main\\resources\\2015\\day03.txt");
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }


        System.out.println("#### Part One:");
        int x = 0;
        int y = 0;
        int[][] houses = new int[999][999];

        houses[x][y] = 1;

        for (var move : lines.get(0).split("")) {
            switch (move) {
                case "^" -> y++;
                case "v" -> y--;
                case "<" -> x--;
                case ">" -> x++;
            }
            houses[x][y] += 1;
        }

        int count = 0;
        for (var a : houses) {
            for (var b : a) {
                count++;
            }
        }

        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", count);


        System.out.println("#### Part Two:");

        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", "");
    }
}
