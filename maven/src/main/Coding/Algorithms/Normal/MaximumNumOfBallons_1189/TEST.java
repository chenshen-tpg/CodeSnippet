package main.Coding.Algorithms.Normal.MaximumNumOfBallons_1189;

import java.util.HashMap;

public class TEST {
    public static void main(String[] args) {

    }
    public int maxNumberOfBalloons(String text) {
        int ans = 0;
        HashMap<Character,Integer> hm = new HashMap();
        for (char cc : text.toCharArray()) {
            hm.put(cc, hm.getOrDefault(cc, 0) + 1);
        }

        int a,b,l,o,n;
        if (hm.containsKey('a') && hm.containsKey('b')
                && hm.containsKey('l') && hm.containsKey('o')
                && hm.containsKey('n')) {
            a = hm.get('a');
            b = hm.get('b');
            l = hm.get('l');
            o = hm.get('o');
            n = hm.get('n');
        } else {
            return ans;
        }
        while (a >= 1 && b >= 1 && l >= 2 && o >= 2 && n >= 1) {
            ans++;
            a -= 1;
            b -= 1;
            l -= 2;
            o -= 2;
            n -= 1;
        }
        return ans;
    }
}
