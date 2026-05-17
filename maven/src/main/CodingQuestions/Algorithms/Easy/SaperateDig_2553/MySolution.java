package main.CodingQuestions.Algorithms.Easy.SaperateDig_2553;

public class MySolution {
    /***
     *
     *
     Given an array of positive integers nums, return an array answer that consists of the digits of each integer in nums after separating them in the same order they appear in nums.

     To separate the digits of an integer is to get all the digits it has in the same order.

     For example, for the integer 10921, the separation of its digits is [1,0,9,2,1].


     Example 1:

     Input: nums = [13,25,83,77]
     Output: [1,3,2,5,8,3,7,7]
     Explanation:
     - The separation of 13 is [1,3].
     - The separation of 25 is [2,5].
     - The separation of 83 is [8,3].
     - The separation of 77 is [7,7].
     answer = [1,3,2,5,8,3,7,7]. Note that answer contains the separations in the same order.
     Example 2:

     Input: nums = [7,1,3,9]
     Output: [7,1,3,9]
     Explanation: The separation of each integer in nums is itself.
     answer = [7,1,3,9].
     *
     */
    public static void main(String[] args) {
        MySolution obj = new MySolution();
        obj.separateDigits(new int[]{100, 80, 40, 60});
        //3,2,4,3,6,8,8,1,0,0,8,4,8,0,1,4,8,8,4,2,5,3,9,8,6,9,6,4,4,0,6,0,2,3,9,9
    }

    public int[] separateDigits(int[] nums) {
        int len = 0;
        for (int num : nums) {
            int cur = num;
            while (cur > 0) {
                cur /= 10;
                len++;
            }
        }
        int[] memo = new int[len];
        int index = -1;
        for (int num : nums) {
            int cur = num, cal = 0;
            while (cur > 0) {
                cur /= 10;
                cal++;
            }
            index += cal;
            while (num > 0) {
                memo[index--] = num % 10;
                num /= 10;
            }
            index += cal;
        }
        return memo;
    }

}
