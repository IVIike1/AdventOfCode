package at.gruber.dev.y2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day03 {
    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get("D:\\Daten\\Dokumente\\IntellijProjects\\AdventOfCode\\src\\main\\resources\\2022\\day03_1.txt");
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }


        System.out.println("#### Part One:");
        int sum = 0;
        for (var l : lines) {
            int lenHalf = l.length() / 2;
            String c1 = l.substring(0, lenHalf);
            String c2 = l.substring(lenHalf);

            //System.out.println(c1 + " : " + c2);
            String common = findCommonElements(c1, c2);
            int point = getPointOfCommon(common);
            sum += point;
            //System.out.println("   " + common + " " + point);
        }

        System.out.printf(Locale.GERMANY, "  The answer is: %d%n", sum);


        System.out.println("#### Part Two:");
        int sum2 = 0;
        int idx = 0;
        String[] co = new String[3];
        int idxG = 0;
        for (var l : lines) {

            co[idx % 3] = l;

            idx++;

            if (idx % 3 == 0) {
                int point2 = findCommonElementsGroup(co);
                sum2 += point2;
                idxG++;
            }

        }
        System.out.printf(Locale.GERMANY, "  The answer is: %d%n", sum2);
    }

    private static int findCommonElementsGroup(String[] co) {

        char found = 0;

        for (var c1 : co[0].split("")) {
            for (var c2 : co[1].split("")) {
                for (var c3 : co[2].split("")) {
                    if (c1.equals(c2) && c2.equals(c3)) {
                        found = c1.charAt(0);
                        break;
                    }
                }
            }
        }

        return getPointOfCommon(found);
    }

    private static int getPointOfCommon(String common) {
        return getPointOfCommon(common.charAt(0));
    }

    private static int getPointOfCommon(char c) {

        if (c > 96) {
            return (int) c - 96;
        } else {
            return (int) c - 64 + 26;
        }
    }

    private static String findCommonElements(String c1, String c2) {
        String[] arr1 = c1.split("");
        String[] arr2 = c2.split("");

        for (String value : arr1) {
            for (String s : arr2) {
                if (value.equals(s)) {
                    return value;

                }
            }
        }
        return "";
    }
}

