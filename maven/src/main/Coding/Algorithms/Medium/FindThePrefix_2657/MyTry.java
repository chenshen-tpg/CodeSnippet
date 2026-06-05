package main.Coding.Algorithms.Medium.FindThePrefix_2657;

import java.util.HashSet;
import java.util.Set;

public class MyTry {
    public static void main(String[] args) {
        int [] A = new int [] {1,3,2,4};
        int [] B  = new int [] {3,1,2,4};
        MyTry obj = new MyTry();
        obj.findThePrefixCommonArray(A,B);
    }
    public int[] findThePrefixCommonArrayHashSet(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];

        Set<Integer> setA = new HashSet<Integer>();
        Set<Integer> setB = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            setA.add(A[i]);
            setB.add(B[i]);
            int commonCount = 0;
            for (int element : setA) {
                if (setB.contains(element)) {
                    commonCount++;
                }
            }
            ans[i] = commonCount;
        }
        return ans;
    }
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans = new int[A.length];
        int[] freq = new int[A.length + 1];
        int common = 0;
        for(int i = 0; i < A.length; i++){
            freq[A[i]]++;
            if(freq[A[i]] == 2){
                common++;
            }
            freq[B[i]]++;
            if(freq[B[i]] == 2){
                common++;
            }
            ans[i] = common;
        }
        return ans;
    }
}
