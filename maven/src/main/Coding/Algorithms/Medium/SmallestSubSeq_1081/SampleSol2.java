package main.Coding.Algorithms.Medium.SmallestSubSeq_1081;

public class SampleSol2 {
    public static void main(String[] args) {
        SampleSol2 test = new SampleSol2();
        test.smallestSubsequence("cbacdcbc");
    }

    public String smallestSubsequence(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (sb.indexOf(ch + "") != -1) {
                continue;
            }
            //last one in sb larger than the current one and current one more than one deleted.
            while (!sb.isEmpty() && sb.charAt(sb.length() - 1) > ch && s.indexOf(sb.charAt(sb.length() - 1)+"", i) != -1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
