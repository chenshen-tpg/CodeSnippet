package CodingQuestions.Algorithms.Medium.AddBoldTagInString_616;


/***


 You are given a string s and an array of strings words.

 You should add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in words.

 If two such substrings overlap, you should wrap them together with only one pair of closed bold-tag.
 If two substrings wrapped by bold tags are consecutive, you should combine them.
 Return s after adding the bold tags.



 Example 1:

 Input: s = "abcxyz123", words = ["abc","123"]
 Output: "<b>abc</b>xyz<b>123</b>"
 Explanation: The two strings of words are substrings of s as following: "abcxyz123".
 We add <b> before each substring and </b> after each substring.



 */
public class ModelAnswer {
    public static void main(String[] args) {
        ModelAnswer solution = new ModelAnswer();
        solution.addBoldTag("abcxyz123", new String[]{"abc", "123"});
    }

    public String addBoldTag(String s, String[] words) {
        boolean[] bold = new boolean[s.length()];
        for (String word : words) {
            int start = s.indexOf(word);
            while (start != -1) {
                for (int i = start; i < start + word.length(); i++) {
                    bold[i] = true;
                }
                start = s.indexOf(word, start + 1);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (bold[i] && (i == 0 || !bold[i - 1])) ans.append("<b>");
            ans.append(s.charAt(i));
            if (bold[i] && (i == s.length() - 1 || !bold[i + 1])) ans.append("</b>");
        }
        return ans.toString();
    }
}
