package at.gruber.dev.y2015;

import at.gruber.dev.FileHelper;

import java.util.List;

public class Day01 {

    public static void main(String[] args) {
        List<String> lines = new FileHelper().getFileContent(1, 2015);

        int floor = 0;

        for (var l : lines) {
            for (var s : l.split("")) {

                if (s.equals("(")) {
                    floor++;
                } else if (s.equals(")")) {
                    floor--;
                }

            }
        }
        System.out.println("#### Part One:");
        System.out.println("Santa stands in floor " + floor);

        System.out.println("#### Part Two:");

        var found = false;
        var position = 1;
        var floor1 = 0;
        var fl = lines.get(0).split("");

        for (var val : fl) {
            floor1 += (val.equals("(") ? 1 : -1);
            if (floor1 == -1) {
                found = true;
            }

            if (!found) {
                position++;
            }
        }

        System.out.println("Position of basement: " + position);
    }


}
