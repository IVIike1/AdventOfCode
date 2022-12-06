package at.gruber.dev.y2022;

import at.gruber.dev.FileHelper;

import java.util.*;

public class Day04 {
    public static void main(String[] args) {

        List<String> lines = new FileHelper().getFileContent(4);


        System.out.println("#### Part One:");
        int pairContains = 0;
        int pairsOverlap = 0;
        for (var l : lines) {
            var s1 = l.split(",")[0];
            var s2 = l.split(",")[1];
            Set<Integer> range1 = getRange(s1);
            Set<Integer> range2 = getRange(s2);
            pairContains += checkContains(range1, range2);
            pairsOverlap += checkOverLap(range1, range2);
        }
        System.out.printf(Locale.GERMANY, "  The answer is: %d%n", pairContains);


        System.out.println("#### Part Two:");

        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", pairsOverlap);
    }

    private static int checkOverLap(Set<Integer> range1, Set<Integer> range2) {
        for (var r1 : range1) {
            for (var r2 : range2) {
                if (Objects.equals(r1, r2)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private static int checkContains(Set<Integer> range1, Set<Integer> range2) {
        boolean r = range2.containsAll(range1) || range1.containsAll(range2);
        return (r ? 1 : 0);
    }

    private static Set<Integer> getRange(String s1) {
        Set<Integer> ret = new HashSet<>();

        int start = Integer.parseInt(s1.split("-")[0]);
        int end = Integer.parseInt(s1.split("-")[1]);
        for (int i = start; i <= end; i++) {
            ret.add(i);
        }

        return ret;
    }
}
