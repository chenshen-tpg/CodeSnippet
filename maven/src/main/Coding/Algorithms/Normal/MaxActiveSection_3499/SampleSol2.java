package main.Coding.Algorithms.Normal.MaxActiveSection_3499;

public class SampleSol2 {
    public static void main(String[] args) {
        SampleSol2 test = new SampleSol2();
        test.maxActiveSectionsAfterTrade("0100");
    }

    public int maxActiveSectionsAfterTrade(String s) {
        int oneCount = 0, convertedOne = 0, curZeroCount = 0, lastZeroCount = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') curZeroCount++;
            else {
                if (curZeroCount != 0) lastZeroCount = curZeroCount;
                curZeroCount = 0;
                oneCount++;
            }
            convertedOne = Math.max(convertedOne, curZeroCount + lastZeroCount);
        }
        if (convertedOne == curZeroCount || convertedOne == lastZeroCount) return oneCount;
        return oneCount + convertedOne;
    }
}
