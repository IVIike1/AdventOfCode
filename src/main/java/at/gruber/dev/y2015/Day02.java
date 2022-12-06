package at.gruber.dev.y2015;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Day02 {
    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get("D:\\Daten\\Dokumente\\IntellijProjects\\AdventOfCode\\src\\main\\resources\\2015\\day02.txt");
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.err.println("not found:" + e.getLocalizedMessage());
        }


        System.out.println("#### Part One:");
        int sum = 0;
        for (var l : lines) {
            sum += calcSurface(l);
        }


        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", sum);


        System.out.println("#### Part Two:");
        int sum2 = 0;
        for (var l : lines) {
            sum2 += calcRibbon(l);
        }
        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", sum2);
    }

    private static int calcRibbon(String line) {
        var t = line.split("x");
        int l = Integer.parseInt(t[0]);
        int w = Integer.parseInt(t[1]);
        int h = Integer.parseInt(t[2]);

        int[] sorted = new int[]{l, w, h};
        Arrays.sort(sorted);

        return l * w * h + (sorted[0] + sorted[0] + sorted[1] + sorted[1]);
    }

    private static int calcSurface(String line) {
        var t = line.split("x");
        int l = Integer.parseInt(t[0]);
        int w = Integer.parseInt(t[1]);
        int h = Integer.parseInt(t[2]);

        int area1 = 2 * l * w;
        int area2 = 2 * w * h;
        int area3 = 2 * h * l;

        int smallest = findSmallest(area1, area2, area3) / 2;

        return area1 + area2 + area3 + smallest;
    }

    private static int findSmallest(int a, int b, int c) {
        int smallest;
        if (a < b) {
            smallest = Math.min(c, a);
        } else {
            smallest = Math.min(b, c);
        }
        return smallest;
    }
}
