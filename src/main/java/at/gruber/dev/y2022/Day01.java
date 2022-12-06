package at.gruber.dev.y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day01 {
    public Day01() {
        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get("D:\\Daten\\Dokumente\\gru\\AdventOfCode\\2022\\day01.txt");

            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }
        List<ElfCalories> elves = new ArrayList<>();

        int idxElf = 0;
        int elfMax = 0;
        int idxElfMax = 0;
        int elfCarry = 0;

        for (var l : lines) {

            if (l.equals("")) {
                elves.add(new ElfCalories(idxElf, elfCarry));

                //   System.out.println("elf " + idxElf + " carries " + elfCarry + " calories");

                if (elfCarry > elfMax) {
                    elfMax = elfCarry;
                    idxElfMax = idxElf;
                }


                idxElf++;
                elfCarry = 0;
            } else {

                elfCarry += Integer.parseInt(l);
            }

            // System.out.println(l);

        }

        //System.out.println("we have " + idxElf + " elves");
        System.out.println("### Part One:");
        System.out.println("  Elf with ID " + idxElfMax + " has the most calories: " + elfMax);

        System.out.println("### Part Two:");
        elves.sort(Comparator.comparing(ElfCalories::getCalories, Comparator.reverseOrder()));

        int sum3 = 0;
        for (int i = 0; i < 3; i++) {
            // System.out.println(elves.get(i).calories);
            sum3 += elves.get(i).calories;
        }
        System.out.println("  The 3 elves carrying the most have " + sum3 + " calories");
    }

    private class ElfCalories {
        private int idx = 0;
        private int calories = 0;

        public ElfCalories(int i, int c) {
            this.idx = i;
            this.calories = c;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public int getCalories() {
            return calories;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }
    }
}
