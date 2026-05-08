package CodingQuestions.Algorithms.Medium.RotatingTheBox_1861;

public class Template {
    public char[][] rotateTheBox90(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char [][] newGrid = new char [n][m];
        for (int i = 0; i < m;i++) {
            for (int j = 0; j < n;j++) {
                newGrid[j][m - i - 1] = boxGrid[i][j];
            }
        }
        return newGrid;
    }
    public char[][] rotateTheBox180(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char [][] newGrid = new char [m][n]; // should be m x n
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newGrid[m - i - 1][n - j - 1] = boxGrid[i][j];
            }
        }
        return newGrid;
    }
    public char[][] rotateTheBox270(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char [][] newGrid = new char [n][m];
        for (int i = 0; i < m;i++) {
            for (int j = 0; j < n;j++) {
                newGrid[n - j - 1][i] = boxGrid[i][j];
            }
        }
        return newGrid;
    }
    public void display (char[][] boxGrid) {
        for (int i = 0; i < boxGrid.length; i++) {
            for (int j = 0; j < boxGrid[0].length; j++) {
                System.out.print(boxGrid[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] boxGrid1 = {
                {'#', '.', '*'},
                {'.', '#', '.'}
        };
        Template obj = new Template();
        System.out.println("Rotation of 90 degree being like: ");
        char[][] rotated90 = obj.rotateTheBox90(boxGrid1);
        obj.display(rotated90);
        System.out.println();
        System.out.println("Rotation of 180 degree being like: ");
        char[][] rotated180 = obj.rotateTheBox180(boxGrid1);
        obj.display(rotated180);
        System.out.println();
        System.out.println("Rotation of 270 degree being like: ");
        char[][] rotated270 = obj.rotateTheBox270(boxGrid1);
        obj.display(rotated270);
    }
}
