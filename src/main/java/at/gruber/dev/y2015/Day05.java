package at.gruber.dev.y2015;

import at.gruber.dev.FileHelper;

import java.util.List;
import java.util.Locale;

public class Day05 {
    public static int naughty = 0;
    public static int nice = 0;

    public static void main(String[] args) {

        List<String> lines = new FileHelper().getFileContent(5, 2015);


        System.out.println("#### Part One:");
        for (var l : lines) {
            checkNaughtyOrNice(l);
        }
        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", nice);


        System.out.println("#### Part Two:");

        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", "");
    }

    static String[] vowels = new String[]{"a", "e", "i", "o", "u"};
    static String[] not = new String[]{"ab", "cd", "pq", "xy"};

    private static void checkNaughtyOrNice(String l) {

        boolean isNice = false;

        int cv = 0;
        for (var v : vowels) {
            if (l.contains(v)) {
                cv++;
            }
        }

        if (cv >= 3) {
            isNice = true;
        }

        String cBefore = "";
        for (String ll : l.split("")) {
            // System.out.println(cBefore + ":" + ll);
            if (cBefore.equals(ll)) {
                System.out.println(l + " contains 2 " + cBefore);
                isNice = true;
                break;
            }
            cBefore = ll;
        }

        for (var n : not) {
            if (l.contains(n)) {
                System.out.println("  " + l + " contains " + n);
                isNice = false;
                break;
            }
        }


        if (isNice) {
            nice++;
        } else {
            naughty++;
        }
    }
}
