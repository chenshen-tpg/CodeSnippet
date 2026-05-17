package CodingQuestions.Algorithms.Medium.BasicCalculator_227;


/***
 Given a string s which represents an expression, evaluate this expression and return its value.

 The integer division should truncate toward zero.

 You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

 Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().



 Example 1:

 Input: s = "3+2*2"
 Output: 7
 Example 2:

 Input: s = " 3/2 "
 Output: 1
 Example 3:

 Input: s = " 3+5 / 2 "
 Output: 5
 */
public class SampleAnswer {
    int i = 0;

    public int calculate(String s) {
        return calculator(s);
    }

    private int calculator(String s) {
        int num = 0;
        int ans = 0;
        int sign = 1;

        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                num = calculator(s);
            } else if (c == ')') {
                return (ans = ans + num * sign);
            } else if (c == '+' || c == '-') {
                ans = ans + num * sign;
                num = 0;
                sign = (c == '-') ? -1 : 1;
            }
        }
        ans = ans + num * sign;
        return ans;
    }
}
