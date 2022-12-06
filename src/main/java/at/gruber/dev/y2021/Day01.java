package at.gruber.dev.y2021;

import at.gruber.dev.FileHelper;

import java.util.List;
import java.util.Locale;

public class Day01 {
    public static void main(String[] args) {

        List<String> lines = new FileHelper().getFileContent(1, 2021);

        System.out.println("#### Part One:");
        int depthBefore = Integer.parseInt(lines.get(0));
        int inc = 0;
        for (var l : lines) {
            if (Integer.parseInt(l) > depthBefore) {
                inc++;
            }
            depthBefore = Integer.parseInt(l);
        }

        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", inc);


        System.out.println("#### Part Two:");
        int inc2 = 0;
        int depthBefore2 = 0;
        for (var i = 2; i < lines.size(); i++) {
            var curr = Integer.parseInt(lines.get(i - 2)) + Integer.parseInt(lines.get(i - 1)) + Integer.parseInt(lines.get(i));

            if (depthBefore2 > 0 && curr > depthBefore2) {
                inc2++;
            }
            depthBefore2 = curr;
        }

        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", inc2);
    }
}
