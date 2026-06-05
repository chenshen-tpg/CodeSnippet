package main.Coding.Algorithms.Normal.BinaryGap_868;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        System.out.println(test.binaryGap(22));
    }
    public int binaryGap(int n) {
        String s = Integer.toString(n, 2);
        int ans = 0;
        int indexf = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('1' == s.charAt(i)) {
                if (i > indexf) {
                    ans = Math.max(ans, i - indexf);
                    indexf = i;
                }
            }
        }
        return ans;
    }
}
