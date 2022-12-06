package at.gruber.dev.y2015;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class Day04 {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        String secret = "iwrupvqb";

        System.out.println("#### Part One:");
        MessageDigest md = MessageDigest.getInstance("MD5");

        int i = 0;
        int found ;
        while (true) {

            md.update((secret + i).getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();
            StringBuilder hex = new StringBuilder();
            for (byte b : digest) {
                hex.append(String.format("%02x", b));
            }
            if (hex.toString().startsWith("00000")) {
                System.out.println(hex);
                found = i;
                break;
            }
            i++;
        }
        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", found);


        System.out.println("#### Part Two:");
        i = 0;
        int found2 ;
        while (true) {

            md.update((secret + i).getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();
            StringBuilder hex = new StringBuilder();
            for (byte b : digest) {
                hex.append(String.format("%02x", b));
            }
            if (hex.toString().startsWith("000000")) {
                System.out.println(hex);
                found2 = i;
                break;
            }
            i++;
        }
        System.out.printf(Locale.GERMANY, "  The answer is: %s%n", found2);
    }
}
