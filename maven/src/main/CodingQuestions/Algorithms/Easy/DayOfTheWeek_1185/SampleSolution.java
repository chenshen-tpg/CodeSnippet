package main.CodingQuestions.Algorithms.Easy.DayOfTheWeek_1185;

public class SampleSolution {
    public static void main(String[] args) {

    }

    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Friday","Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday"};
        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        int totalDays = 0;
        for (int y = 1971; y < year; y++) {
            totalDays += (isLeap(y) ? 366 : 365);
        }
        for (int m = 1; m < month; m++) {
            totalDays += monthDays[m-1];
            if (m == 2 && isLeap(year)) totalDays++;
        }
        totalDays += day - 1;
        return days[totalDays % 7];
    }
    private boolean isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
}
