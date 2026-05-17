package CodingQuestions.Algorithms.Medium.findCheapestFlight_787;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TEST {
    /***
     *
     There are n cities connected by some number of flights. You are given an array flights
     where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city from I to city to I
     with cost price I.

     You are also given three integers src, dst, and k,
     return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

     Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
     Output: 700
     Explanation:
     The graph is shown above.
     The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
     Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
     */
    public static void main(String[] args) {
        TEST obj = new TEST();
        int n = 4;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        int src = 0, dst = 3, k = 1;
        int expected = 700;

        int actual = obj.findCheapestPrice(n, flights, src, dst, k);
        System.out.println("actual = " + actual + ", expected = " + expected);

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] i : flights)
            adj.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[]{i[1], i[2]});
        System.out.println();
        return 0;
    }
}
