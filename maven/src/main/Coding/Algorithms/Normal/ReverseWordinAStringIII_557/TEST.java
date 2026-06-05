package main.Coding.Algorithms.Normal.ReverseWordinAStringIII_557;

public class TEST {
    public static void main(String[] args) {

    }
    
    public String reverseWords(String s) {
        String [] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            for (int j = ss[i].length() - 1; j >= 0; j--) {
                sb.append(ss[i].charAt(j));
            }
            if (i != ss.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
