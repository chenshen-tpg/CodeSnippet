package main.Coding.Algorithms.Normal.ExcelSheet_171;

public class TEST {
    public static void main(String[] args) {
        String columnTitle = "ZY";
        int ans = 0;
        for (char temp : columnTitle.toCharArray()) {
            ans *= 26;
            ans += (temp - 'A' + 1);
        }
        System.out.println(ans);
    }
}
