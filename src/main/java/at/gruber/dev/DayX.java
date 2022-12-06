package at.gruber.dev;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DayX {
    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get("D:\\Daten\\Dokumente\\IntellijProjects\\AdventOfCode\\src\\main\\resources\\2022\\dayX.txt");
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }


        System.out.println("#### Part One:");

        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", "");


        System.out.println("#### Part Two:");

        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", "");
    }
}
