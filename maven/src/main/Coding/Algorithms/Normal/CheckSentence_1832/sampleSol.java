package main.Coding.Algorithms.Normal.CheckSentence_1832;

public class sampleSol {
    public static void main(String[] args) {

    }
    public boolean checkIfPangram(String sentence) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!sentence.contains(String.valueOf(ch))) {
                return false;
            }
        }
        return true;
    }
}
