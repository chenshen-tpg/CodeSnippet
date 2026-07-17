package main.Coding.Algorithms.Normal.PathCrossing_1496;


import java.util.HashSet;
import java.util.Set;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.isPathCrossing("NES");
    }

    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        int x = 0, y = 0;
        for (char p : path.toCharArray()) {
            if (p == 'N') y++;
            else if (p == 'S') y--;
            else if (p == 'W') x++;
            else if (p == 'E') x--;
            String pos = x + ","+ y;
            if (!visited.add(pos)) {
                return true;
            }
        }
        return false;
    }
}
