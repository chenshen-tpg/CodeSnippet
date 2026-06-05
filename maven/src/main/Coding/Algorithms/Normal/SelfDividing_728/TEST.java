package main.Coding.Algorithms.Normal.SelfDividing_728;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        test.selfDividingNumbers(1,22);
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> li = new ArrayList();
        for (int i = left; i <= right; i++) {
            String temp = String.valueOf(i);
            boolean addable = true;
            if (temp.contains("0"))
                addable = false;
            for (int j = 0; j < temp.length(); j++) {
                if (Integer.valueOf(temp.charAt(j) - '0') != 0) {
                    if (Integer.valueOf(temp) % Integer.valueOf(temp.charAt(j) - '0') != 0) {
                        addable = false;
                        break;
                    }
                }
            }
            if (addable)
                li.add(i);
        }
        return li;
    }
}
