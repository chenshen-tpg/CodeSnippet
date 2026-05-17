package main.CodingQuestions.Algorithms.Medium.ApplySubstitutions_3481;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/***
 *
 *
 You are given a replacements mapping and a text string that may contain placeholders formatted as %var%, where each var corresponds to a key in the replacements mapping.

 Each replacement value may itself contain one or more such placeholders. Each placeholder is replaced by the value associated with its corresponding replacement key.

 Return the fully substituted text string which does not contain any placeholders.

 Example 1:

 Input: replacements = [["A","abc"],["B","def"]], text = "%A%_%B%"

 Output: "abc_def"

 Explanation:

 The mapping associates "A" with "abc" and "B" with "def".
 Replace %A% with "abc" and %B% with "def" in the text.
 The final text becomes "abc_def".
 Example 2:

 Input: replacements = [["A","bce"],["B","ace"],["C","abc%B%"]], text = "%A%_%B%_%C%"

 Output: "bce_ace_abcace"

 Explanation:

 The mapping associates "A" with "bce", "B" with "ace", and "C" with "abc%B%".
 Replace %A% with "bce" and %B% with "ace" in the text.
 Then, for %C%, substitute %B% in "abc%B%" with "ace" to obtain "abcace".
 The final text becomes "bce_ace_abcace".
 *
 *
 */
public class SampleAnswer {
    public static void main(String[] args) {

    }

    public String applySubstitutions(List<List<String>> replacements, String text) {
        Map<String, String> hm = new HashMap<>();
        for (List<String> replacement : replacements) {
            hm.put(replacement.get(0), replacement.get(1));
        }
        boolean changed;
        do {
            changed = false;
            for (String key : hm.keySet()) {
                String value = hm.get(key);
                String newValue = value;
                for (String replaceKey : hm.keySet()) {
                    newValue = newValue.replace("%" + replaceKey + "%", hm.get(replaceKey));
                }
                if (!newValue.equals(value)) {
                    hm.put(key, newValue);
                    changed = true;
                }
            }
        } while (changed);
        String result = text;
        for (String key : hm.keySet()) {
            result = result.replace("%" + key + "%", hm.get(key));
        }
        return result;
    }
}
