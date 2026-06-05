package main.Coding.Algorithms.Normal.Coupon_3606;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();

        String[] events = {"GROCERY15", "ELECTRONICS_50", "DISCOUNT10"};
        String[] businessLine = {"grocery", "electronics", "invalid"};
        boolean[] isActive = {false, true, true};
        System.out.println(test.validateCoupons(events,businessLine,isActive));

    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String[]> valid = new ArrayList<>();

        Map<String, Integer> rank = Map.of(
                "electronics", 0,
                "grocery", 1,
                "pharmacy", 2,
                "restaurant", 3
        );

        for (int i = 0; i < code.length; i++) {
            if (!isActive[i]) continue;
            if (!rank.containsKey(businessLine[i])) continue;
            if (code[i] == null || code[i].isEmpty()) continue;

            boolean add = true;
            for (int j = 0; j < code[i].length(); j++) {
                char cur = code[i].charAt(j);
                if (!Character.isLetterOrDigit(cur) && cur != '_') {
                    add = false;
                    break;
                }
            }

            if (add) {
                valid.add(new String[]{code[i], businessLine[i]});
            }
        }

        valid.sort(
                java.util.Comparator
                        .comparing((String[] a) -> rank.get(a[1]))
                        .thenComparing(a -> a[0])
        );

        List<String> ans = new ArrayList<>();
        for (String[] item : valid) {
            ans.add(item[0]);
        }
        return ans;
    }
}
