package main.CodingQuestions.Algorithms.Medium.CountMentioned_3433;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Initial {

    public static void main(String[] args) {
        List<List<String>> events3 = new java.util.ArrayList<>(List.of(
                new java.util.ArrayList<>(List.of("MESSAGE", "2", "HERE")),
                new java.util.ArrayList<>(List.of("OFFLINE", "2", "1")),
                new java.util.ArrayList<>(List.of("OFFLINE", "1", "0")),
                new java.util.ArrayList<>(List.of("MESSAGE", "61", "HERE"))
        ));
        Initial solver = new Initial();
        int[] result3 = solver.countMentions(3, events3);
        System.out.println(Arrays.toString(result3));
    }
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
//        events.sort((a, b) -> {
//            int timeA = Integer.parseInt(a.get(1));
//            int timeB = Integer.parseInt(b.get(1));
//            if (timeA != timeB) {
//                return Integer.compare(timeA, timeB);
//            }
//            boolean aIsMessage = a.get(0).equals("MESSAGE");
//            boolean bIsMessage = b.get(0).equals("MESSAGE");
//            return Boolean.compare(aIsMessage, bIsMessage);
//        });
        events.sort(
                Comparator.comparing((List<String> e) -> Integer.parseInt(e.get(1)))
                        .thenComparing(e -> !e.get(0).equals("MESSAGE"))
        );
        int[] ans = new int[numberOfUsers];
        int[] onlineTimeTable = new int[numberOfUsers];
        for (List<String> event : events) {
            String messageType = event.get(0);
            int currentTime = Integer.parseInt(event.get(1));
            String payload = event.get(2);
            if ("MESSAGE".equals(messageType)) {
                if (!"ALL".equals(payload) && !"HERE".equals(payload)) {
                    String[] arr = payload.split(" ");
                    for (String user : arr) {
                        int num = user.indexOf("d") + 1;
                        int cur = Integer.parseInt(user.substring(num));
                        ans[cur]++;
                    }
                } else if ("ALL".equals(payload)) {
                    for (int i = 0; i < ans.length; i++) {
                        ans[i]++;
                    }
                } else {
                    for (int i = 0; i < ans.length; i++) {
                        if (currentTime - onlineTimeTable[i] >= 0) {
                            ans[i]++;
                        }
                    }
                }
            } else if ("OFFLINE".equals(messageType)) {
                String[] arr = payload.split(" ");
                for (String user : arr) {
                    int curUser = Integer.parseInt(user);
                    onlineTimeTable[curUser] = currentTime + 60;
                }
            }
        }
        return ans;
    }
}
