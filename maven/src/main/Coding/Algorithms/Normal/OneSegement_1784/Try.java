package main.Coding.Algorithms.Normal.OneSegement_1784;

public class Try {
    public static void main(String[] args) {
        Try obj = new Try();
        obj.checkOnesSegment("110");
    }
    public boolean checkOnesSegment(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 1) {
                count++;
            }
            while (i < s.length() && s.charAt(i) == 1) {
                i++;
            }

        }
        return count == 1;
    }
}
