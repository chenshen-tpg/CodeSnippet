package main.Coding.Algorithms.Normal.TwoFurthestColour_2078;

public class SampleSolution {
    public static void main(String[] args) {

    }

    public int maxDistance(int[] colors) {
        int l = 0;
        int n = colors.length;
        int r = n - 1;
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                r = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                l = i;
                break;
            }
        }
        int rightans = n - 1 - r;
        int leftans = l;
        return Math.max(rightans, leftans);
    }
}
