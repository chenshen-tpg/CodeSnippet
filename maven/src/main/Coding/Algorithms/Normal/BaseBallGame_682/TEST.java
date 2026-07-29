package main.Coding.Algorithms.Normal.BaseBallGame_682;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    public int calPoints(String[] operations) {
        List<Integer> li = new ArrayList();
        for (String op : operations) {
            if (op.equals("D")) {
                li.add(li.get(li.size() - 1) * 2);
            } else if (op.equals("C")) {
                li.remove(li.get(li.size() - 1));
            } else if (op.equals("+")) {
                int cur = li.get(li.size() - 1) + li.get(li.size() - 2);
                li.add(cur);
            } else {
                li.add(Integer.parseInt(op));
            }
        }
        int ans = 0;
        for (int i = 0; i < li.size(); i++) {
            ans += li.get(i);
        }
        return ans;
    }
}
