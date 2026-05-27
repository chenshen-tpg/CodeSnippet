package main.CodingQuestions.Algorithms.Easy.NumberOfSegementsInAString_434;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
//        System.out.println(test.countSegments(", , , ,        a, eaefa"));
        String temp = ", , , ,        a, eaefa";
        System.out.println(temp.split("\\s+").length);
    }

    public int countSegments(String s) {
        int start = 1;
        if (s.startsWith(" ")) {
            start --;
        }
        int len = s.length();
        for (int i = 0; i < len; i ++) {
            while (i < len && s.charAt(i) == ' ') {
                i++;
            }
            while (i < len && s.charAt(i) != ' ') {
                i++;
            }
            start++;
        }
        return start;
    }

    public int inLineSolution(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
    public int builtInWay(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
}
