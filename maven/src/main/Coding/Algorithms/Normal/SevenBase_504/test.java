package main.Coding.Algorithms.Normal.SevenBase_504;

public class test {
    public static void main(String[] args) {
        test obj = new test();
        System.out.println(obj.convertToBase7(-100));
    }

    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean minus = false;
        if (num < 0) {
            minus = true;
        }
        num = Math.abs(num);
        while (num > 0) {
            int rem = num % 7;
            sb.append(rem);
            num /= 7;
        }

        return minus? sb.append("-").reverse().toString():sb.reverse().toString();
    }
    
    public String convertToBase7OnLine(int num) {
        return Integer.toString(num, 7);
    }
}
