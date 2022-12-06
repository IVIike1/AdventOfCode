package at.gruber.dev.y2021;

import at.gruber.dev.FileHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Day03 {
    static List<String> lines;
    static int width;

    public static void main(String[] args) {

        lines = new FileHelper().getFileContent(3, 2021);

        System.out.println("#### Part One:");
        StringBuilder gRate = new StringBuilder();
        StringBuilder eRate = new StringBuilder();

        width = lines.get(0).length();

        for (var c = 1; c <= width; c++) {
            int anz0 = 0;
            int anz1 = 0;

            for (var l : lines) {
                int v = Integer.parseInt(l.split("")[c - 1]);
                if (v == 0) {
                    anz0++;
                } else if (v == 1) {
                    anz1++;
                }
            }
            if (anz1 > anz0) {
                gRate.append("1");
                eRate.append("0");
            } else {
                gRate.append("0");
                eRate.append("1");
            }
        }
        int gamma = Integer.parseInt(gRate.toString(), 2);
        int epsilon = Integer.parseInt(eRate.toString(), 2);
        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", gamma * epsilon);

        System.out.println("#### Part Two:");

        List<String> lo = new ArrayList<>(lines);
        List<String> lc = new ArrayList<>(lines);

        int oRate = getORate(lo);
        int cRate = getCRate(lc);


        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", oRate * cRate);
    }

    private static int getCRate(List<String> lines) {
        for (int i = 0; i < width; i++) {
            int c = 0;
            for (String line : lines) {
                c += Character.getNumericValue(line.charAt(i));
            }
            boolean dominantBit = (c < (lines.size() / 2.0));
            final int index = i;
            lines.removeIf(line -> line.charAt(index) == (dominantBit ? '0' : '1'));
            if (lines.size() == 1) break;
        }
        int rating = 0;
        for (int i = 0; i < width; i++) {
            if (lines.get(0).charAt(i) == '1') rating |= (1 << Math.abs(i - width + 1));
        }
        return rating;
    }

    private static int getORate(List<String> lines) {
        for (int i = 0; i < width; i++) {
            int c = 0;
            for (String line : lines) {
                c += Character.getNumericValue(line.charAt(i));
            }
            boolean dominantBit = (c >= (lines.size() / 2.0));
            final int index = i;
            lines.removeIf(line -> line.charAt(index) == (dominantBit ? '0' : '1'));
            if (lines.size() == 1) break;
        }
        int rating = 0;
        for (int i = 0; i < width; i++) {
            if (lines.get(0).charAt(i) == '1') rating |= (1 << Math.abs(i - width + 1));
        }
        return rating;
    }


}
