package main.CodingQuestions.Algorithms.Easy.EarliestTimeWater_3633;

public class TEST {


public static void main(String[] args) {
    TEST sol = new TEST();

    int[] landStartTime = {2, 8};
    int[] landDuration = {4, 1};
    int[] waterStartTime = {6};
    int[] waterDuration = {3};

    int actual = sol.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
    int expected = 9;

    System.out.println("Expected: " + expected);
    System.out.println("Actual: " + actual);
    System.out.println("Pass: " + (actual == expected));
}
    public int earliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration
    ) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                int land = Math.max(landStartTime[i] + landDuration[i], waterStartTime[j]) + waterDuration[j];
                res = Math.min(res, land);
                int water = Math.max(waterStartTime[j] + waterDuration[j], landStartTime[i]) + landDuration[i];
                res = Math.min(res, water);
            }
        }
        return res;
    }
}
