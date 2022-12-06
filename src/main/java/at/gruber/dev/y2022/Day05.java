package at.gruber.dev.y2022;

import at.gruber.dev.FileHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Stack;

public class Day05 {
    static List<Stack<String>> crates = new ArrayList<>();

    public static void main(String[] args) {

        List<String> lines = FileHelper.getFileContent(5);


        fillCrates(crates);
        printCrates();

        System.out.println("#### Part One:");
        moveCrates(lines);
        printCrates();
        System.out.printf(Locale.GERMANY, "  The answer is: %s%n%n", getTopElements());

        crates = new ArrayList<>();
        fillCrates(crates);
        printCrates();
        System.out.println("#### Part Two:");
        moveCratesP2(lines);
        printCrates();
        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", getTopElements());
    }

    private static void moveCratesP2(List<String> lines) {
        for (var l : lines) {
            int moveAnz = Integer.parseInt(l.split(" from ")[0].replace("move ", ""));
            int from = Integer.parseInt(l.split(" from ")[1].split(" to ")[0]);
            int to = Integer.parseInt(l.split(" to ")[1]);
            moveCrate2(moveAnz, from - 1, to - 1);

        }
    }

    private static void moveCrate2(int anz, int from, int to) {
        List<String> pop = new ArrayList<>();
        for (int x = 0; x < anz; x++) {
            var o = crates.get(from).pop();
            pop.add(o);
        }
        for (int x = pop.size() - 1; x >= 0; x--) {
            crates.get(to).push(pop.get(x));
        }
    }

    private static String getTopElements() {
        StringBuilder sb = new StringBuilder();
        for (var s : crates) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    private static void moveCrates(List<String> lines) {
        for (var l : lines) {
            int moveAnz = Integer.parseInt(l.split(" from ")[0].replace("move ", ""));
            int from = Integer.parseInt(l.split(" from ")[1].split(" to ")[0]);
            int to = Integer.parseInt(l.split(" to ")[1]);
            moveCrate(moveAnz, from - 1, to - 1);
        }
    }

    private static void moveCrate(int anz, int from, int to) {
        for (int x = 0; x < anz; x++) {
            var o = crates.get(from).pop();
            crates.get(to).push(o);
        }
    }

    private static void printCrates() {
        int maxHeight = 0;
        for (var s : crates) {
            if (s.size() > maxHeight) {
                maxHeight = s.size();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int row = maxHeight - 1; row >= 0; row--) {
            for (var s : crates) {
                if (s.size() > row) {
                    sb.append("[").append(s.get(row)).append("] ");
                } else {
                    sb.append("    ");
                }
            }
            sb.append("\n");
        }
        int idx = 1;
        for (var ignored : crates) {
            sb.append(" ").append(idx).append("  ");
            idx++;
        }

        System.out.println(sb);

    }

    private static void fillCrates(List<Stack<String>> crates) {
        crates.add(new Stack<>());
        crates.add(new Stack<>());
        crates.add(new Stack<>());
        crates.add(new Stack<>());
        crates.add(new Stack<>());
        crates.add(new Stack<>());
        crates.add(new Stack<>());
        crates.add(new Stack<>());
        crates.add(new Stack<>());

        crates.get(0).push("H");
        crates.get(0).push("B");
        crates.get(0).push("V");
        crates.get(0).push("W");
        crates.get(0).push("N");
        crates.get(0).push("M");
        crates.get(0).push("L");
        crates.get(0).push("P");

        crates.get(1).push("M");
        crates.get(1).push("Q");
        crates.get(1).push("H");

        crates.get(2).push("N");
        crates.get(2).push("D");
        crates.get(2).push("B");
        crates.get(2).push("G");
        crates.get(2).push("F");
        crates.get(2).push("Q");
        crates.get(2).push("M");
        crates.get(2).push("L");

        crates.get(3).push("Z");
        crates.get(3).push("T");
        crates.get(3).push("F");
        crates.get(3).push("Q");
        crates.get(3).push("M");
        crates.get(3).push("W");
        crates.get(3).push("G");

        crates.get(4).push("M");
        crates.get(4).push("T");
        crates.get(4).push("H");
        crates.get(4).push("P");

        crates.get(5).push("C");
        crates.get(5).push("B");
        crates.get(5).push("M");
        crates.get(5).push("J");
        crates.get(5).push("D");
        crates.get(5).push("H");
        crates.get(5).push("G");
        crates.get(5).push("T");

        crates.get(6).push("M");
        crates.get(6).push("N");
        crates.get(6).push("B");
        crates.get(6).push("F");
        crates.get(6).push("V");
        crates.get(6).push("R");

        crates.get(7).push("P");
        crates.get(7).push("L");
        crates.get(7).push("H");
        crates.get(7).push("M");
        crates.get(7).push("R");
        crates.get(7).push("G");
        crates.get(7).push("S");

        crates.get(8).push("P");
        crates.get(8).push("D");
        crates.get(8).push("B");
        crates.get(8).push("C");
        crates.get(8).push("N");


    }
}
