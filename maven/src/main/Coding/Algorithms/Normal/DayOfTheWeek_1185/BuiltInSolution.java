package main.Coding.Algorithms.Normal.DayOfTheWeek_1185;

import java.time.LocalDate;

public class BuiltInSolution {
    public static void main(String[] args) {

    }
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        LocalDate date = LocalDate.of(year, month, day);
        int idx = date.getDayOfWeek().getValue() % 7; // Java's week starts from Monday=1
        return days[idx];
    }
}
