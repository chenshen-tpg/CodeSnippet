package main.CodingQuestions.Algorithms.Medium.CountMentioned_3433;

import java.util.Arrays;
import java.util.List;

public class Initial {
    public static void main(String[] args) {
        int numberOfUsers = 2;
        List<List<String>> events = List.of(
                List.of("MESSAGE", "10", "id1 id0"),
                List.of("OFFLINE", "11", "0"),
                List.of("MESSAGE", "12", "ALL")
        );
        List<List<String>> events2 = List.of(
                List.of("OFFLINE", "10", "0"),
                List.of("MESSAGE", "12", "HERE")
        );
        Initial solver = new Initial();
        int[] result = solver.countMentions(numberOfUsers, events);
        System.out.println(Arrays.toString(result));

        int[] result2 = solver.countMentions(numberOfUsers, events2);
        System.out.println(Arrays.toString(result2));
    }
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] ans = new int[numberOfUsers];
        int[] onlineTimeTable = new int[numberOfUsers];
        Arrays.fill(onlineTimeTable, -1);
        for (List<String> event : events) {
            int currentTime = Integer.parseInt(event.get(1));
            String payload = event.get(2);
            if (event.get(0) == "MESSAGE") {
                String messageType = event.get(2);
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
                        if (currentTime - onlineTimeTable[i] < 60 || onlineTimeTable[i] == 0) {
                            ans[i]++;
                        }
                    }
                }
            } else if ("OFFLINE".equals(event.get(0))) {
                String[] arr = payload.split(" ");
                for (String user : arr) {
                    int curUser;
                    if (user.startsWith("id")) {
                        curUser = Integer.parseInt(user.substring(2));
                    } else {
                        curUser = Integer.parseInt(user);
                    }

                    if (curUser >= 0 && curUser < numberOfUsers) {
                        onlineTimeTable[curUser] = currentTime;
                    }
                }
            }
        }
        return ans;
    }
}

