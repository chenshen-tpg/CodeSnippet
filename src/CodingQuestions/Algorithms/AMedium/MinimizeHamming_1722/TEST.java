package CodingQuestions.Algorithms.AMedium.MinimizeHamming_1722;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.minimumHammingDistance(new int[] {1,2,3,4}, new int [] {2,1,4,5}, new int [][] {{0,1},{2,3}});
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int count = 0;
        int len = source.length;
        int [] cop = Arrays.copyOf(source,len);
        int temp = 0;
        for (int i = 0; i < allowedSwaps.length;i++) {
            temp = cop[allowedSwaps[i][0]];
            cop[allowedSwaps[i][0]] = cop[allowedSwaps[i][1]];
            cop[allowedSwaps[i][1]] = temp;
        }
        for (int i = 0; i < len; i++) {
            if (cop[i] == target[i]) {
                count++;
            }
        }
        return count;
    }
}
