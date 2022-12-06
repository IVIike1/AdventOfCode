package at.gruber.dev;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    public static List<String> getFileContent(int day) {
        return getFileContent(day, 2022);
    }

    public static List<String> getFileContent(int day, int year) {

        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get("D:\\Daten\\Dokumente\\IntellijProjects\\AdventOfCode\\src\\main\\resources\\" + year + "\\day" + padLeft(day) + ".txt");
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }

        return lines;
    }

    private static String padLeft(int input) {
        String inputString = "" + input;
        if (inputString.length() >= 2) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 2 - inputString.length()) {
            sb.append("0");
        }
        sb.append(inputString);

        return sb.toString();
    }

}
