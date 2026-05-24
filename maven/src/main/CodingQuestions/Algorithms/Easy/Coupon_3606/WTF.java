package main.CodingQuestions.Algorithms.Easy.Coupon_3606;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WTF {
    private boolean isValidCode(String s) {
        if (s == null || s.length() == 0) return false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!(Character.isLetterOrDigit(c) || c == '_')) {
                return false;
            }
        }
        return true;
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        List<String> e = new ArrayList<>();
        List<String> g = new ArrayList<>();
        List<String> p = new ArrayList<>();
        List<String> r = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {

            if (!isActive[i] || !isValidCode(code[i])) continue;

            String b = businessLine[i];

            if (b.equals("electronics")) e.add(code[i]);
            else if (b.equals("grocery")) g.add(code[i]);
            else if (b.equals("pharmacy")) p.add(code[i]);
            else if (b.equals("restaurant")) r.add(code[i]);
        }

        Collections.sort(e);
        Collections.sort(g);
        Collections.sort(p);
        Collections.sort(r);

        List<String> result = new ArrayList<>(code.length);
        result.addAll(e);
        result.addAll(g);
        result.addAll(p);
        result.addAll(r);

        return result;
    }
}
