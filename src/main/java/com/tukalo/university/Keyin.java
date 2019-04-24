package com.tukalo.university;

class Keyin {

    private static void printPrompt() {
        System.out.print(" Select numeric: " + " ");
        System.out.flush();
    }

    private static void inputFlush() {
        int dummy;
        try {
            while ((System.in.available()) != 0)
                dummy = System.in.read();
        } catch (java.io.IOException e) {
            System.out.println("Input error");
        }
    }

    static String inString() {
        int aChar;
        String s = "";
        boolean finished = false;

        while (!finished) {
            try {
                aChar = System.in.read();
                if (aChar < 0 || (char) aChar == '\n')
                    finished = true;
                else if ((char) aChar != '\r')
                    s = s + (char) aChar;
            } catch (java.io.IOException e) {
                System.out.println("Input error");
                finished = true;
            }
        }
        return s;
    }

    static int inInt() {
        while (true) {
            inputFlush();
            printPrompt();
            try {
                return Integer.valueOf(inString().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Not an integer");
            }
        }
    }

}

