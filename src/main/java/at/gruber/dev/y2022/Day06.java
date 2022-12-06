package at.gruber.dev.y2022;

import at.gruber.dev.FileHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Day06 {
    public static void main(String[] args) {

        List<String> lines = FileHelper.getFileContent(6);

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
