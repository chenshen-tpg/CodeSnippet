package main.Coding.Algorithms.Medium.shortestlexo_2094;

public class TEST {
    public static void main(String[] args) {
        String s = "110101000010110101";
        int k = 3;
        TEST test = new TEST();
        System.out.println(test.helper(s,k));
    }

    public String helper (String s, int k) {
        int oneSum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') oneSum++;
        }
        if (oneSum < k) {
            return "";
        }
        int start = -1;
        int index = 0;
        int sum = 0;
        int cur = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sum++;
            }
            while (sum >= k) {
                if (sum == k) {
                    int len = i - index + 1;
                    String candidate = s.substring(index, i + 1);
                    String best = start == -1 ? null : s.substring(start, start + cur);

                    if (len < cur || (len == cur && candidate.compareTo(best) < 0)) {
                        start = index;
                        cur = len;
                    }
                }
//                if (sum == k) {
//                    int len = i - index + 1;
//                    if (start == -1 || len < cur ||
//                            (len == cur && s.substring(index, i + 1).compareTo(s.substring(start, start + cur)) < 0)) {
//                        start = index;
//                        cur = len;
//                    }
//                }

                if (s.charAt(index) == '1') {
                    sum--;
                }
                index++;

            }

        }
        return start == -1 ? "" : s.substring(start, start + cur);
    }
}
