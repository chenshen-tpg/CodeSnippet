package main.Coding.Algorithms.Medium.BaldWord_758;


public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.helper("abcxyz123", new String[]{"abc", "123"});
    }

    public void helper(String s, String[] words) {
        int len = s.length();
        boolean[] memo = new boolean[len];
        for (String word : words) {
            int cur = s.indexOf(word);
            while (cur != -1) {
                for (int i = cur; i < cur + word.length(); i++) {
                    memo[i] = true;
                }
                cur = s.indexOf(word, cur + 1);
            }
        }
        System.out.println(normalGenerator(memo,s,len));
        System.out.println(twoPointerGenerator(memo,s,len));
        System.out.println(flagGenerator(memo,s,len));
    }
    public String normalGenerator (boolean [] memo, String s, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (memo[i] && (i == 0 || !memo[i - 1])) sb.append("<b>");
            sb.append(s.charAt(i));
            if (memo[i] && (i == len - 1 || !memo[i + 1])) sb.append("</b>");
        }
        return sb.toString();
    }
    public String twoPointerGenerator (boolean [] memo, String s, int len) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < len) {
            if (!memo[i]) {
                sb.append(s.charAt(i++));
                continue;
            }
            sb.append("<b>");
            while (i < len && memo[i]) {
                sb.append(s.charAt(i++));
            }
            sb.append("</b>");
        }
        return sb.toString();
    }
    public String flagGenerator (boolean [] memo, String s, int len) {
        StringBuilder sb = new StringBuilder();
        boolean inBold = false;
        for (int i = 0; i < len; i++) {
            if (memo[i] && !inBold) {
                sb.append("<b>");
                inBold = true;
            }
            if (!memo[i] && inBold) {
                sb.append("</b>");
                inBold = false;
            }
            sb.append(s.charAt(i));
        }
        if (inBold) sb.append("</b>");
        return sb.toString();
    }
}
