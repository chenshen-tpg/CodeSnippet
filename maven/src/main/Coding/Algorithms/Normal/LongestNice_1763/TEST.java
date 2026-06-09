package main.Coding.Algorithms.Normal.LongestNice_1763;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        System.out.println(test.longestNiceSubstring("YazaAay"));
    }
    public String longestNiceSubstring(String s) {
        int length = s.length();
        if (s.length() == 1) return "";
        int ans = 0;
        int start = 0, end = 0;
        for (int i = 1; i < length; i++) {
            int j = i;
            while (j < length && (  
                    s.charAt(j) == (char)(s.charAt(j-1) + 32)
                            || s.charAt(j) == (char)(s.charAt(j-1) - 32)))
            {
                j++;
            }
            if (j - (i - 1) > ans) {
                ans = j - (i - 1);
                end = j;
                start = i - 1;
            }
        }
        return s.substring(start, end);
    }
}
