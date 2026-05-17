package main.CodingQuestions.Algorithms.Medium.Jumpgame3_1306;


import java.util.LinkedList;
import java.util.Queue;


public class TEST {
    public static void main(String[] args) {
        TEST obj = new TEST();
        obj.canReach(new int[] {4,2,3,0,3,1,2}, 0);
    }

    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (arr[cur] == 0) {
                return true;
            }
            if (arr[cur] < 0) {
                continue;
            }
            if (cur + arr[cur] < arr.length && cur + arr[cur] >= 0) {
                q.offer(cur + arr[cur]);
            }
            if (cur - arr[cur] >= 0 && cur - arr[cur] < arr.length) {
                q.offer(cur - arr[cur]);
            }
            arr[cur] = -arr[cur];
        }
        return false;
    }

}
