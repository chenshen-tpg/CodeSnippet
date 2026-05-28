package main.CodingQuestions.Algorithms.Easy.GoatLatin_824;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        System.out.println(test.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int wordCount = 1;
        int wordS = 0;
        int len = sentence.length();
        while (index < len) {
            if (sentence.charAt(index) != ' ') {
                wordS = index;
            }
            while (index < len && sentence.charAt(index) != ' ') {
                index++;
            }

            String cur = sentence.substring(wordS, index);
            if (checkVowel(cur.charAt(0) + "")) {
                sb.append(cur);
                sb.append("m");
                for (int i = 0; i <= wordCount; i++) {
                    sb.append("a");
                }
                if (index != len) {
                    sb.append(" ");
                }
            } else if (!checkVowel(cur.charAt(0) + "")){
                sb.append(cur.substring(1, cur.length()));
                sb.append(cur.charAt(0));
                sb.append("m");
                for (int i = 0; i <= wordCount; i++) {
                    sb.append("a");
                }
                if (index != len) {
                    sb.append(" ");
                }
            }
            wordCount++;
            index++;
        }
        return sb.toString();
    }


    public boolean checkVowel (String s) {
        if ("AEIOUaeriou".contains(s)) return true;
        else return false;
    }
}
