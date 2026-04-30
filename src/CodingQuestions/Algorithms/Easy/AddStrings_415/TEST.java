package CodingQuestions.Algorithms.Easy.AddStrings_415;

public class TEST {
    public static void main(String[] args) {
        TEST obj = new TEST();
        System.out.println(obj.addStrings("12","91"));
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int cur = 0;
        while (i >= 0 || j >= 0 || cur != 0) {
            int dig1 = 0, dig2 = 0;
            if (i >= 0) {
                dig1 = num1.charAt(i) - '0';
            } else {
                dig1 = 0;
            }
            if (j >= 0) {
                dig2 = num2.charAt(j) - '0';
            } else {
                dig2 = 0;
            }
            int sum = dig1 + dig2 + cur;
            sb.append(sum % 10);
            cur = sum / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
