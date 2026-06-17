package main.Coding.Algorithms.Normal.FurtherstPointFromOrigin_2833;

public class TEST {
    public static void main(String[] args) {

    }
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0, u = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'L') l++;
            else if (c == 'R') r++;
            else u++; // '_'
        }
        return Math.abs(l - r) + u;
    }
}
