package main.CodingQuestions.Algorithms.Easy.Coupon_3606;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SampleAnswer {
    public static void main(String[] args) {

    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String>[] bucket = new ArrayList[4];
        for (int i = 0; i < 4; i++) bucket[i] = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (!isActive[i]) continue;           // cheapest check first

            String c = code[i];
            if (c == null || c.isEmpty()) continue; // avoid isValid call entirely

            String b = businessLine[i];
            if (b == null) continue;

            int idx = getIndex(b);
            if (idx == -1) continue;              // skip isValid if bucket invalid

            if (isValid(c)) bucket[idx].add(c);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Collections.sort(bucket[i]);
            result.addAll(bucket[i]);
            bucket[i] = null;                     // release bucket memory immediately
        }
        return result;
    }

    private int getIndex(String b) {
        // Order by expected frequency (most common first) to short-circuit faster
        if (b.equals("grocery"))     return 1;
        if (b.equals("electronics")) return 0;
        if (b.equals("restaurant"))  return 3;
        if (b.equals("pharmacy"))    return 2;
        return -1;
    }

    private boolean isValid(String s) {
        int len = s.length();                     // cache length, avoid repeated calls
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '_') continue;               // most likely special char, check first
            if (c >= 'a' && c <= 'z') continue;  // lowercase most common, check first
            if (c >= 'A' && c <= 'Z') continue;
            if (c >= '0' && c <= '9') continue;
            return false;
        }
        return true;
    }
}
