package main.Coding.Algorithms.Normal.PokerHand_2347;

public class TEST {

    public static void main(String[] args) {
        TEST tes = new TEST();
        System.out.println(
                tes.bestHand(new int [] {4,4,2,4,4}, new char [] {'a','b','c','a','a'})
        );
    }


    public String bestHand(int[] ranks, char[] suits) {
        int len = ranks.length;
        int [] suitCount = new int [5];
        int [] rankCount = new int [14];
        for (int i = 0; i < len; i++) {
            rankCount[ranks[i]]++;
            suitCount[suits[i] - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            if (suitCount[i] == 5) {
                return "Flush";
            }
        }
        for (int i = 0; i < 14; i++) {
            if (rankCount[i] >= 3) {
                return "Three of a Kind";
            }
        }
        for (int i = 0; i < 14; i++) {
            if (rankCount[i] == 2) {
                return "Pair";
            }
        }
        return "High Card";
    }
}
