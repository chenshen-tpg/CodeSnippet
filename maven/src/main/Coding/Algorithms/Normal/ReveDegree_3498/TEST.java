package main.Coding.Algorithms.Normal.ReveDegree_3498;

public class TEST {
    public static void main(String[] args) {

    }
    public int reverseDegree(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            int val = temp - 'a';
            int res = 0;
            for (int j = val; j < 26; j++) {
                res++;
            }
            sum += (i+1) * res;
        }
        return sum;
    }
}
