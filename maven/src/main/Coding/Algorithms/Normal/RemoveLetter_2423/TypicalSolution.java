package main.Coding.Algorithms.Normal.RemoveLetter_2423;

public class TypicalSolution {
    public static void main(String[] args) {

    }
    public boolean equalCount(int[] count) {
        int c = 0;

        for (int i: count) {
            if (i == 0) {
                continue;
            } else if (c == 0) {
                c = i;
            } else if (c == i) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
    private boolean isEqual(int[] data){
        int lastCount = 0;
        for (int count: data){
            if (count == 0) continue;
            if (lastCount != 0 && count != lastCount) return false;
            lastCount = count;
        }
        return true;
    }
}
