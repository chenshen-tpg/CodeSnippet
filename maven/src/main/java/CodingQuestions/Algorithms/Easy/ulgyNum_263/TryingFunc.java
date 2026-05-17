package CodingQuestions.Algorithms.Easy.ulgyNum_263;

public class TryingFunc {
    public static void main(String[] args) {
        int n = 999;
        for (int i : new int[]{2, 3, 5}) {
            while (n % i == 0) {
                n /= i;
            }
        }
        System.out.println(n);
    }
}
