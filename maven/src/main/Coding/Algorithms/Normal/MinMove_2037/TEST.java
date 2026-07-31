package main.Coding.Algorithms.Normal.MinMove_2037;

import java.util.Arrays;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
//        System.out.println(test.helper(new int [] {3,1,5}, new int [] {2,7,4}));
//        System.out.println(test.helper(new int [] {4,1,5,9}, new int [] {1,3,2,6}));
        System.out.println(test.minMovesToSeat(new int [] {12,14,19,19,12}, new int [] {19,2,17,20,7}));
    }


    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }
        return moves;
    }
}
