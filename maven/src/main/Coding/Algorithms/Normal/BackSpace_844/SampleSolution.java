package main.Coding.Algorithms.Normal.BackSpace_844;

public class SampleSolution {
    public static void main(String[] args) {

    }

    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        while (i >= 0 || j >= 0) {
            i = nextValidIndex(s, i);
            j = nextValidIndex(t, j);
            if (i < 0 && j < 0) {
                return true;
            }
            if (i < 0 || j < 0) {
                return false;
            }
            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    private int nextValidIndex(String str, int idx) {
        int skip = 0;
        while (idx >= 0) {
            char c = str.charAt(idx);
            if (c == '#') {
                skip++;
                idx--;
            } else if (skip > 0) {
                skip--;
                idx--;
            } else {
                break;
            }
        }

        return idx;
    }
}
