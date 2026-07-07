package main.Coding.Algorithms.Normal.TwoFurthestColour_2078;

public class TEST {
    public static void main(String[] args) {

    }
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (colors[0] != colors[colors.length - 1 - i] || colors[colors.length - 1] != colors[i]) {
                return colors.length - i - 1;
            }
        }
        return 0;
    }
    public int maxDistance_bruteForce(int[] colors) {
        int max=0;
        int n=colors.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(colors[i]!=colors[j]){
                    max=Math.max(max,Math.abs(i-j));
                }
            }
        }
        return max;
    }
}
