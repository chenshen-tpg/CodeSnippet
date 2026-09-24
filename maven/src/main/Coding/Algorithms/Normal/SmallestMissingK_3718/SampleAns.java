package main.Coding.Algorithms.Normal.SmallestMissingK_3718;

public class SampleAns {

    public static void main(String[] args) {

    }

    public int missingMultiple(int[] nums, int k) {
        boolean arr[] = new boolean[101];
        for (int n : nums) {
            arr[n] = true;
        }
        int i = k;
        while (i < arr.length) {
            i += k;
            if (!arr[i]) {
                return i;
            }
        }
        return i;
    }
}
