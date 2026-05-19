package main.CodingQuestions.Algorithms.Medium.CountMentioned_3433;

import java.util.List;

public class Initial {
    class Solution {
        public int[] countMentions(int numberOfUsers, List<List<String>> events) {
            int [] ans = new int [100];
            int [] online = new int [numberOfUsers];
            int index = 0;
            int currentTime;
            for (List<String> event : events) {
                int count = 0;
                int [] users = new int [numberOfUsers];
                currentTime = Integer.valueOf(event.get(1));
                String id = event.get(2);
                if (event.get(0) == "MESSAGE") {
                    String messageType = event.get(3);
                    if (messageType != "ALL" && messageType != "HERE") {
                        String [] arr = id.split(" ");
                        for (String user : arr) {
                            int num = user.indexOf("d") + 1;
                            int cur = Integer.parseInt(user.substring(num));
                            users[cur]++;
                        }
                        for (int user : users) {
                            if (user > 0) {
                                count++;
                            }
                        }
                        ans[index++] = count;
                    } else if (messageType == "All") {
                        ans[index++] = numberOfUsers;
                    } else {
                        int curCount = 0;
                        for (int onlineuser : online) {
                            if (onlineuser > 0) {
                                curCount++;
                            }
                        }
                        ans[index++] = curCount;
                    }
                } else {
                    String [] arr = id.split(" ");
                    for (String user : arr) {
                        int num = user.indexOf("d") + 1;
                        int cur = Integer.parseInt(user.substring(num));

                    }
                }
            }
            return ans;
        }
    }
}
