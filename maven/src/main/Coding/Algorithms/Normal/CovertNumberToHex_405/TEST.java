package main.Coding.Algorithms.Normal.CovertNumberToHex_405;

public class TEST {

    public static void main(String[] args) {
        TEST test = new TEST();
        test.toHex(26);

    }

    //num & 0xf extracts the last 4 bits (one hex digit).
    

    public String toHex(int num) {
        if (num == 0) return "0";
        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        // Use unsigned right shift to handle negative numbers (two's complement)
        while (num != 0 && sb.length() < 8) { // 8 hex digits for 32 bits
            int hexDigit = num & 0xf; // get last 4 bits
            sb.append(hexChars[hexDigit]);
            num >>>= 4; // unsigned shift
        }
        return sb.reverse().toString();
    }
}
