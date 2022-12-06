package at.gruber.dev.y2022;

import at.gruber.dev.FileHelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day01 {
    public static void main(String[] args) {
        List<String> lines = new FileHelper().getFileContent(1);

        List<ElfCalories> elves = new ArrayList<>();

        int idxElf = 0;
        int elfMax = 0;
        int idxElfMax = 0;
        int elfCarry = 0;

        for (var l : lines) {

            if (l.equals("")) {
                elves.add(new ElfCalories(elfCarry));

                if (elfCarry > elfMax) {
                    elfMax = elfCarry;
                    idxElfMax = idxElf;
                }


                idxElf++;
                elfCarry = 0;
            } else {

                elfCarry += Integer.parseInt(l);
            }

        }

        System.out.println("### Part One:");
        System.out.println("  Elf with ID " + idxElfMax + " has the most calories: " + elfMax);

        System.out.println("### Part Two:");
        elves.sort(Comparator.comparing(ElfCalories::getCalories, Comparator.reverseOrder()));

        int sum3 = 0;
        for (int i = 0; i < 3; i++) {
            sum3 += elves.get(i).calories;
        }
        System.out.println("  The 3 elves carrying the most have " + sum3 + " calories");
    }

    private static class ElfCalories {
        private int calories;

        public ElfCalories(int c) {
            setCalories(c);
        }

        public int getCalories() {
            return calories;
        }

        public void setCalories(int calories) {
            this.calories = calories;
        }
    }
}
