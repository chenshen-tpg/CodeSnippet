package main.CodingQuestions.Algorithms.Easy.ButtonWithLongestPress_3386;

import java.util.HashMap;

public class TEST {
    public static void main(String[] args) {
        TEST t = new TEST();
//        int[][] events = {{1,2},{2,5},{3,9},{1,15}};
//        System.out.println(t.buttonWithLongestTime(events));

        int[][] events2 = {{7,1},{19,3},{9,4},{12,5},{2,8},{15,10},{18,12},{7,14},{19,16}};
        System.out.println(t.buttonWithLongestTime(events2)); // expected: 2
    }

    // don't now why it only counts consecutive events.
    public int buttonWithLongestTime(int[][] events) {
        HashMap<Integer,Integer> hm = new HashMap();
        int previous = 0;
        for (int [] event : events) {
            if (hm.containsKey(event[0])) {
                hm.put(event[0], hm.get(event[0]) + event[1] - previous);
            } else {
                hm.put(event[0], event[1] - previous);
            }
            previous = event[1];
        }
        int max = 0;
        int ans = 0;
        for (int i : hm.keySet()) {
            if (hm.get(i) > max) {
                max = hm.get(i);
                ans = i;
            }
        }
        return ans;
    }
}
