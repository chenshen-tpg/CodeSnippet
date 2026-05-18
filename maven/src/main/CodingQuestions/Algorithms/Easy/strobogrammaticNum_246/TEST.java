package main.CodingQuestions.Algorithms.Easy.strobogrammaticNum_246;

public class TEST {
    /***
     *
     *
     Given a string num which represents an integer,
     return true if num is a strobogrammatic number.

     A strobogrammatic number is a number
     that looks the same when rotated 180 degrees
     (looked at upside down).
     */
    public static void main(String[] args) {
        TEST obj = new TEST();
        obj.isStrobogrammatic("1");
    }


    public boolean isStrobogrammatic(String num) {
        int len = num.length();
        if (len == 1) {
            if (num.charAt(0) == 0 || num.charAt(0) == 1 || num.charAt(0) == 8) {
                return true;
            } else {
                return false;
            }
        }

        if (len > 2 && (num.contains("2") && num.indexOf(2) != len / 2 ||
                num.contains("3") && num.indexOf(3) != len / 2 ||
                num.contains("4") && num.indexOf(4) != len / 2 ||
                num.contains("5") && num.indexOf(5) != len / 2 ||
                num.contains("7") && num.indexOf(7) != len / 2)
        ) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (num.charAt(i) == 6 && num.charAt(len - i) != 9) {
                return false;
            }

        }
        return true;
    }
}
