package main.CodingQuestions.Algorithms.Medium.CountMentioned_3433;

public class TEST {
    public static void main(String[] args) {
        String s = "id01 id02 id03";
        String [] ss = s.split(" ");
        for (String cur : ss) {
            System.out.println(cur.substring(cur.indexOf("d") + 1));
        }
    }
}
