package main.SomeParticalExamples.Implementation;

import java.util.HashMap;
import lombok.Synchronized;

public class LatestMapSumUsage {

/*The Scenario: "We have a cache of user balances. Multiple threads update it.
What is wrong with this code, and how do you fix it without using synchronized?"
*/
    private final HashMap<String, Long> map = new HashMap<>();


    public void updateBalance(String userId, Long amount) {
        HashMap<String, Long> map = new HashMap<>();
        Long currentBalance = map.get(userId);
        if (currentBalance == null) {
            map.put(userId, amount);
        } else {
            map.put(userId, currentBalance + amount);
        }
    }

    public void refineMethod(String[] args) {
        HashMap<String, Long> map = new HashMap<>();
        map.merge("1", 10L, Long::sum);
        map.merge("1", 5L, Long::sum);
        map.merge("2", 7L, Long::sum);
        System.out.println(map);
    }

    @Synchronized
    public void updateBalanceAnnotation(String userId, Long amount) {
        Long currentBalance = map.get(userId);
        if (currentBalance == null) {
            map.put(userId, amount);
        } else {
            map.put(userId, currentBalance + amount);
        }
    }
}
