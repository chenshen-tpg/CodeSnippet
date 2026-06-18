package main.Coding.Algorithms.Normal.BackSpace_844;

public class TEST {
    public static void main(String[] args) {
        TEST test = new TEST();
        System.out.println(test.backspaceCompare("ab#c","ad#c"));
    }

    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isLetter(cur)) {
                sb.append(cur);
            } else if (cur == '#' && sb.length() > 0) {
                sb.deleteCharAt(sb.length() -1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isLetter(cur)) {
                st.append(cur);
            } else if (cur == '#' && st.length() > 0) {
                st.deleteCharAt(st.length() -1);
            }
        }
        return st.toString().equals(sb.toString());
    }
}
