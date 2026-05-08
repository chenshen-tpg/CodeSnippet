package CodingQuestions.Algorithms.Medium.AlternatingGroupsII_3208;

public class OnePass {
    /***

     There is a circle of red and blue tiles. You are given an array of Integer colors and an integer k. The color of tile i is represented by colors[i]:
     colors[i] == 0 means that tile i is red.
     colors[i] == 1 means that tile i is blue.
     An alternating group is every k contiguous tiles in the circle with alternating colors (each tile in the group except the first and last one has a different color from its left and right tiles).
     Return the number of alternating groups.
     Note that since colors represents a circle, the first and the last tiles are considered to be next to each other.
     Example 1:
     Input: colors = [0,1,0,1,0], k = 3
     Output: 3
     Explanation:
     Alternating groups:
     */
    public static void main(String[] args) {

    }

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int result = 0;
        int count = 1;
        int lastColor = colors[0];
        for (int i = 1; i < colors.length + k - 1; i++) {
            int index = i % colors.length;
            if (colors[index] == lastColor) {
                count = 1;
                lastColor = colors[index];
                continue;
            }
            count += 1;
            if (count >= k) result++;
            lastColor = colors[index];
        }
        return result;
    }
}
