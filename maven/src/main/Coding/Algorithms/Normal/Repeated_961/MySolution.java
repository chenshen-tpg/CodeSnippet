package main.Coding.Algorithms.Normal.Repeated_961;

import java.util.HashSet;

public class MySolution {
    public static void main(String[] args) {

    }
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> hs = new HashSet();
        for (int num : nums) {
            if (hs.contains(num)) {
                return num;
            }
            hs.add(num);

        }
        return -1;
    }
}
