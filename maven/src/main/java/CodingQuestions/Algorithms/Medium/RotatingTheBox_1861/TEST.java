package CodingQuestions.Algorithms.Medium.RotatingTheBox_1861;

public class TEST {
    /***
     *
     You are given an m x n matrix of characters boxGrid representing a side-view of a box. Each cell of the box is one of the following:

     A stone '#'
     A stationary obstacle '*'
     Empty '.'
     The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.

     It is guaranteed that each stone in boxGrid rests on an obstacle, another stone, or the bottom of the box.

     Return an n x m matrix representing the box after the rotation described above.


     Example 1:

     Input: boxGrid = [["#",".","#"]]
     Output: [["."],
     ["#"],
     ["#"]]
     */
    public static void main(String[] args) {
        char[][] boxGrid1 = {
                {'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}
        };
        TEST obj = new TEST();
        obj.display(obj.rotateOnly(boxGrid1));
        System.out.println("Rotation of 90 degree being like: ");
        obj.display(obj.rotateTheBox90(boxGrid1));
        System.out.println("Rotation of 90 degree with top-down gravity simulation being like: ");
        obj.display(obj.rotateTheBox90TopDown(boxGrid1));
    }

    public char[][] rotateOnly(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] newGrid = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newGrid[j][m - i - 1] = boxGrid[i][j];
            }
        }
        return newGrid;
    }

    public char[][] rotateTheBox90(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] newGrid = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newGrid[j][m - i - 1] = boxGrid[i][j];
            }
        }
        //{'#','#','*','.','*','.'},
        for (int col = 0; col < m; col++) {
            int write = n - 1;
            for (int row = n - 1; row >= 0; row--) {
                if (newGrid[row][col] == '*') {
                    write = row - 1;
                } else if (newGrid[row][col] == '#') {
                    if (row != write) {
                        newGrid[row][col] = '.';
                        newGrid[write][col] = '#';
                    }
                    write--;
                }
            }
        }
        return newGrid;
    }

    // Top-down gravity simulation for a rotated box
    public char[][] rotateTheBox90TopDown(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] newGrid = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newGrid[j][m - i - 1] = boxGrid[i][j];
            }
        }
        // Top-down gravity simulation for each column {'#','#','*','.','*','.'},
        for (int col = 0; col < m; col++) {
            int start = 0;
            while (start < n) {
                if (newGrid[start][col] == '*') {
                    start++;
                    continue;
                }
                int end = start;
                while (end < n && newGrid[end][col] != '*') {
                    end++;
                }
                int stoneCount = 0;
                for (int row = start; row < end; row++) {
                    if (newGrid[row][col] == '#') stoneCount++;
                }
                for (int row = end - 1; row >= start; row--) {
                    if (stoneCount > 0) {
                        newGrid[row][col] = '#';
                        stoneCount--;
                    } else {
                        newGrid[row][col] = '.';
                    }
                }
                start = end + 1;
            }
        }
        return newGrid;
    }

    public void display(char[][] boxGrid) {
        for (int i = 0; i < boxGrid.length; i++) {
            for (int j = 0; j < boxGrid[0].length; j++) {
                System.out.print(boxGrid[i][j]);
            }
            System.out.println();
        }
    }
}
