package main.CodingQuestions.Algorithms.Easy.RemoveLetter_2423;

public class TEST {
    public boolean equalFrequency(String word) {
        int[] cnt = new int[26];
        for (char ch : word.toCharArray()) {
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) continue;
            cnt[i]--;
            int target = 0;
            boolean ok = true;
            for (int f : cnt) {
                if (f == 0) continue;
                if (target == 0) target = f;
                else if (f != target) {
                    ok = false;
                    break;
                }
            }
            cnt[i]++;
            if (ok) return true;
        }
        return false;
    }
}
