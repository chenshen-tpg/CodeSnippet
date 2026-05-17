package main.CodingQuestions.Algorithms.Medium.TotalCharactersInString_3335;

public class SampleAns {
    /***
     *
     *
     You are given a string s and an integer t, representing the number of transformations to perform. In one transformation,
     every character in s is replaced according to the following rules:

     If the character is 'z', replace it with the string "ab".
     Otherwise, replace it with the next character in the alphabet. For example, 'a' is replaced with 'b', 'b' is replaced with 'c', and so on.
     Return the length of the resulting string after exactly t transformations.

     Since the answer may be very large, return it modulo 109 + 7.


     Example 1:
     Input: s = "abcyy", t = 2
     Output: 7
     Explanation:

     First Transformation (t = 1):
     'a' becomes 'b'
     'b' becomes 'c'
     'c' becomes 'd'
     'y' becomes 'z'
     'y' becomes 'z'
     String after the first transformation: "bcdzz"
     Second Transformation (t = 2):
     'b' becomes 'c'
     'c' becomes 'd'
     'd' becomes 'e'
     'z' becomes "ab"
     'z' becomes "ab"
     String after the second transformation: "cdeabab"
     Final Length of the string: The string is "cdeabab", which has 7 characters.
     */
    public static void main(String[] args) {
        lengthAfterTransformations("a", 26);
    }

    public static int lengthAfterTransformations(String s, int t) {
        int MOD = (int) 1e9 + 7, ans = 0;
        long[] count = new long[26];
        for (int c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (; t >= 26; t -= 26) {
            long z = count[25];
            for (int i = 25; i > 0; i--) {
                count[i] = (count[i] + count[i - 1]) % MOD;
            }
            count[0] = (count[0] + z) % MOD;
            count[1] = (count[1] + z) % MOD;
        }
        for (int i = 0; i < 26; i++) {
            ans = (int) ((ans + count[i]) % MOD);
        }

        for (int i = 26 - t; i < 26; i++) {
            ans = (int) ((ans + count[i]) % MOD);
        }
        return ans;
    }
}
