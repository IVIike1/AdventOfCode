package at.gruber.dev.y2022;

import at.gruber.dev.FileHelper;

import java.util.List;

public class Day02 {
    int pointWin = 6;
    int pointDraw = 3;
    int pointLoss = 0;

    int anzWin = 0;
    int anzLose = 0;
    int anzDraw = 0;
    int anzWin2 = 0;
    int anzLose2 = 0;
    int anzDraw2 = 0;

    public Day02() {


        List<String> lines = FileHelper.getFileContent(2);

        int points = 0;
        int points2 = 0;

        for (var l : lines) {
            String[] tokens = l.split(" ");
            int w = checkWin(tokens[0], tokens[1]);
            int w2 = checkWin2(tokens[0], tokens[1]);
            points += w;
            points2 += w2;
        }
        System.out.println("#### Part One:");
        System.out.println("  You scored a total of " + points + " points");
        System.out.println("  You won " + anzWin + " times, you lost " + anzLose + " times, you draw " + anzDraw + " times");

        System.out.println("#### Part Two:");
        System.out.println("  You scored a total of " + points2 + " points");
        System.out.println("  You won " + anzWin2 + " times, you lost " + anzLose2 + " times, you draw " + anzDraw2 + " times");

    }

    private int checkWin2(String o, String y) {
        Code opponent = Code.valueOf(o);
        Code toDo = Code.valueOf(y);

        if (toDo == Code.X) { //to lose
            anzLose2++;
            switch (opponent) {
                case A -> {
                    return pointLoss + Code.Z.point;
                }
                case B -> {
                    return pointLoss + Code.X.point;
                }
                case C -> {
                    return pointLoss + Code.Y.point;
                }
            }
        } else if (toDo == Code.Y) { //to draw
            anzDraw2++;
            switch (opponent) {
                case A -> {
                    return pointDraw + Code.X.point;
                }
                case B -> {
                    return pointDraw + Code.Y.point;
                }
                case C -> {
                    return pointDraw + Code.Z.point;
                }
            }

        } else if (toDo == Code.Z) { //to win
            anzWin2++;
            switch (opponent) {
                case A -> {
                    return pointWin + Code.Y.point;
                }
                case B -> {
                    return pointWin + Code.Z.point;
                }
                case C -> {
                    return pointWin + Code.X.point;
                }
            }
        }

        return -1;
    }

    private int checkWin(String o, String y) {
        Code opponent = Code.valueOf(o);
        Code you = Code.valueOf(y);
        //   System.out.println("Opponent choose: " + opponent.name + ", you choose: " + you.name);

        if (opponent.getPoint() == you.getPoint()) {
            //System.err.println("Draw -> " + (pointDraw + you.point) + " points");
            anzDraw++;
            return pointDraw + you.getPoint();
        } else if ((opponent == Code.B && you == Code.X)
                || (opponent == Code.A && you == Code.Z)
                || (opponent == Code.C && you == Code.Y)
        ) {
            //System.err.println("You lose -> " + (pointLoss + you.point) + " points");
            anzLose++;
            return pointLoss + you.getPoint();
        } else if ((opponent == Code.A && you == Code.Y)
                || (opponent == Code.B && you == Code.Z)
                || (opponent == Code.C && you == Code.X)
        ) {
            //System.err.println("You win -> " + (pointWin + you.point) + " points");
            anzWin++;
            return pointWin + you.getPoint();
        }

        return -1; // nix
    }

    public enum Code {
        A("Rock", 1), // E
        X("Rock", 1),
        B("Paper", 2), // E
        Y("Paper", 2),
        C("Scissor", 3), // E
        Z("Scissor", 3);

        private final String name;
        private final int point;

        Code(String n, int p) {
            name = n;
            point = p;
        }

        public String getName() {
            return name;
        }

        public int getPoint() {
            return point;
        }

    }
}
