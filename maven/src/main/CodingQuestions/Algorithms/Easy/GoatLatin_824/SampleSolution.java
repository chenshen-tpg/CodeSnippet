package main.CodingQuestions.Algorithms.Easy.GoatLatin_824;

public class SampleSolution {
    public String toGoatLatin(String sentence) {
        String vowels = "aeiouAEIOU";
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder sb = new StringBuilder();

            if (vowels.indexOf(word.charAt(0)) != -1) {
                sb.append(word);
            } else {
                sb.append(word.substring(1));
                sb.append(word.charAt(0));
            }
            sb.append("ma");
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }

            result.append(sb);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
