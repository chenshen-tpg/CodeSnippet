package CodingQuestions.Algorithms.Easy.ShortestDis_243;

public class SampleAnswer {

    //Instead of using flag, the setting point could be -1 to
    //differentiate the value from initiative.

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int dist = Integer.MAX_VALUE, ind1 = -1, ind2 = -1;

        for (int i = 0; i < wordsDict.length; i++) {
            String s = wordsDict[i];
            if (s.equals(word1)) {
                if (ind2 != -1) {
                    dist = Math.min(dist, i - ind2);
                }

                ind1 = i;
            } else if (s.equals(word2)) {
                ind2 = i;
                if (ind1 != -1) {
                    dist = Math.min(dist, i - ind1);
                }
            }
        }

        return dist;
    }
}
