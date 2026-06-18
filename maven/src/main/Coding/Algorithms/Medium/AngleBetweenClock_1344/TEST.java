package main.Coding.Algorithms.Medium.AngleBetweenClock_1344;

public class TEST {
    public static void main(String[] args) {

    }
    public double angleClock(int hour, int minutes) {
        hour = hour % 12;
        double hourAngle = 30 * hour + 0.5 * minutes;
        double minutesAngle = 6 * minutes;
        double angle = Math.abs(minutesAngle - hourAngle);
        return angle > 180 ? 360 - angle : angle;
    }
}
