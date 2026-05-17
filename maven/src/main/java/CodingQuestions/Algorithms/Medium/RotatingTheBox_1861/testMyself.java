package CodingQuestions.Algorithms.Medium.RotatingTheBox_1861;

public class testMyself {
    public static void main(String[] args) {
        char[] arr = new char[]{'#', '#', '#', '.', '#', '.'};

        int len = arr.length;
        int curIndex = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] == '*') {
                curIndex = i - 1;
            }
            if (i != curIndex) {
                arr[i] = '.';
                arr[curIndex] = '#';
            }
            curIndex--;
        }
        System.out.println(arr);
    }
}
