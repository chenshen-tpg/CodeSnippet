package main.Coding.Algorithms.Normal.CnsArr_3875;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        System.out.println(test.helper(new int [] {30,99,80}));
    }

    public boolean helper (int [] arr) {
        int len = arr.length;
        int [] memo1 = new int [len];
        for (int i = 0; i < len; i++) {
            if (arr[i] % 2 == 0) memo1[i] = 0;
            else memo1[i] = 1;
        }
        int [] memo2 = Arrays.copyOf(memo1, len);
        for (int i = 0; i < len; i++) {
            if (memo2[i] != 0)
                for (int j = 0; j < len; j++) {
                    if (j != i) {
                        if (Math.abs(arr[i] - arr[j]) % 2 == 0) {
                            memo2[i] = 0;
                            break;
                        }
                    }
                }
            if (memo1[i]!= 1){
                for (int j = 0; j < len; j++) {
                    if (j != i) {
                        if (Math.abs(arr[i] - arr[j]) % 2 == 1) {
                            memo1[i] = 1;
                            break;
                        }
                    }
                }
            }
        }
        boolean even = true, odd = true;
        for (int i = 1; i < len; i++) {
            if (memo2[i] != 0 && memo2[i] != memo2[i - 1]) {even = false;}
            if (memo1[i] != 1 && memo1[i] != memo1[i - 1]) {odd = false;}
        }
        return even || odd;
    }
}
