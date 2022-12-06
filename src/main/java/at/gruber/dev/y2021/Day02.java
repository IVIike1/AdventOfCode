package at.gruber.dev.y2021;

import at.gruber.dev.FileHelper;

import java.util.List;
import java.util.Locale;

public class Day02 {
    public static void main(String[] args) {

        List<String> lines = new FileHelper().getFileContent(2, 2021);

        System.out.println("#### Part One:");

        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        int horizontal2 = 0;
        int depth2 = 0;

        for (var l : lines) {
            var tokens = l.split(" ");
            switch (tokens[0]) {
                case "forward" -> {
                    horizontal += Integer.parseInt(tokens[1]);
                    horizontal2 += Integer.parseInt(tokens[1]); //Part Two
                    depth2 += aim * Integer.parseInt(tokens[1]); //Part Two
                }
                case "down" -> {
                    depth += Integer.parseInt(tokens[1]);
                    aim += Integer.parseInt(tokens[1]); //Part Two
                }
                case "up" -> {
                    depth -= Integer.parseInt(tokens[1]);
                    aim -= Integer.parseInt(tokens[1]); //Part Two
                }
            }
        }

        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", horizontal * depth);

        System.out.println("#### Part Two:");
        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", horizontal2 * depth2);
    }
}
