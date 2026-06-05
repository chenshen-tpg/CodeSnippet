package main.Coding.Algorithms.Normal.ShortestDis_243;

public class TEST {
    public static void main(String[] args) {
        TEST obj = new TEST();
//        System.out.println(
//                obj.method(new String [] {"practice", "makes", "perfect", "coding", "makes"},
//                        "makes",
//                        "coding")
//        );
        System.out.println(
                obj.method(new String[]{"this", "is", "a", "long", "sentence", "is", "fun", "day", "today", "sunny", "weather", "is", "a", "day", "tuesday", "this", "sentence", "run", "running", "rainy"}
                        , "weather", "long"
                )
        );
    }

    public int method(String[] wordsDict, String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        int wordIndex = 0, wordIndex2 = 0;
        boolean flag1 = false, flag2 = false;
        for (int i = 0; i < wordsDict.length; i++) {
            // We don't need to compare the initail value since we have the flag,
            // or we could use -1 to indetify if the value of it is changed.
            if (wordsDict[i].equals(word1)) {
                flag1 = true;
                wordIndex = i;
            } else if (wordsDict[i].equals(word2)) {
                flag2 = true;
                wordIndex2 = i;
            }
            if (flag1 && flag2) {
                ans = Math.min(ans, Math.abs(wordIndex2 - wordIndex));
            }
        }
        return ans;
    }
}
