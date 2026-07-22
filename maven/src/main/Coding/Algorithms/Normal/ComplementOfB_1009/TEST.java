package main.Coding.Algorithms.Normal.ComplementOfB_1009;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        System.out.println(Integer.toBinaryString(5));
        System.out.println(test.bitwiseComplement(5));
    }


    public int bitwiseComplement(int n) {
        String temp = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length(); i++) {
            char cur = temp.charAt(i);
            if (cur == '1'){
                sb.append('0');
            } else {
                sb.append('1');
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
