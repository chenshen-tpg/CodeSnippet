package CodingQuestions.Algorithms.Easy.ulgyNum_263;


/***

 An ugly number is a positive integer which does not have a prime factor other than 2, 3, and 5.
 Given an integer n, return true if n is an ugly number.

 Example 1:
 Input: n = 6
 Output: true
 Explanation: 6 = 2 × 3
 Example 2:

 Input: n = 1
 Output: true
 Explanation: 1 has no prime factors.
 */
public class SampleAns {

    public boolean isUgly(int n) {
        if (n <= 0) return false;
        for (int i : new int[]{2, 3, 5}) {
            n = method(n, i);
        }

//        Solution 2
//        for(int i = 2; i <= 5; i++){
//            if(i == 2 || i == 3 || i == 5){
//                while(n % i == 0){
//                    n = n / i;
//                }
//            }
//        }
        return n == 1;
    }

    public int method(int n, int i) {
        while (n % i == 0) n /= i;
        return n;
    }
}
