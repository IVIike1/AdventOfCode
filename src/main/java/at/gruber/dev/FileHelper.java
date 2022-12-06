package at.gruber.dev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    public List<String> getFileContent(int day) {
        return getFileContent(day, 2022, null);
    }

    public List<String> getFileContent(String dayYear) {
        return getFileContent(0, 0, dayYear);
    }

    public List<String> getFileContent(int day, int year) {
        return getFileContent(day, year, null);
    }

    public List<String> getFileContent(int day, int year, String n) {

        List<String> lines = new ArrayList<>();
        try {
            String fileName = null;
            if (n != null && n.length() > 1) {
                fileName = n + ".txt";
            } else if (day > 0 && year > 0) {
                fileName = year + "/day" + padLeft(day) + ".txt";
            }

            if (fileName == null) {
                System.out.println("File '" + day + year + n + "' not found!");
            }

            InputStream is = getFileAsIOStream(fileName);

            try (InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader br = new BufferedReader(isr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
                is.close();
            }
            //lines = Files.readAllLines(Paths.get(FileHelper.class.getClass().getResource(fileName).toURI()));
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }

        return lines;
    }

    private InputStream getFileAsIOStream(final String fileName) {
        InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
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
