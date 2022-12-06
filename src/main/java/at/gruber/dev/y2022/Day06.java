package at.gruber.dev.y2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Day06 {
    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get("D:\\Daten\\Dokumente\\IntellijProjects\\AdventOfCode\\src\\main\\resources\\2022\\day06.txt");
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }


        System.out.println("#### Part One:");
        int pos = 0;
        List<String> list = new ArrayList<>();
        for (var c : lines.get(0).split("")) {
            if (!list.contains(c)) {
                list.add(c);
            } else {
                list = new ArrayList<>();
            }

            if (list.size() == 4) {
                break;
            }

            pos++;
        }
        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", pos);


        System.out.println("#### Part Two:");
        int pos2 = 1;
        List<String> list2 = new ArrayList<>();
        for (var c : lines.get(0).split("")) {
            if (!list2.contains(c)) {
                list2.add(c);
            } else {
                list2 = new ArrayList<>();
            }

            if (list2.size() == 13) {
                break;
            }

            pos2++;
        }
        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", pos2);
    }
}
