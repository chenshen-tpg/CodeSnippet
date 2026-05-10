package CodingQuestions.Algorithms.Easy.strobogrammaticNum_246;

import java.util.HashMap;
import java.util.Map;

public class SampleAnswer {


    public boolean loopTwoPointers(String num) {
        Map<Character, Character> rotatedDigits = new HashMap<>(
                Map.of('0', '0', '1', '1', '6', '9', '8', '8', '9', '6'));
        // Java allows us to have more than one iteration variable.
        for (int left = 0, right = num.length() - 1; left <= right; left++, right--) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            if (!rotatedDigits.containsKey(leftChar) || rotatedDigits.get(leftChar) != rightChar) {
                return false;
            }
        }
        return true;
    }

    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('8', '8');
        map.put('1', '1');
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            Character val = map.get(rightChar);
            if (val == null) {
                return false;
            }
            if (leftChar != val) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
