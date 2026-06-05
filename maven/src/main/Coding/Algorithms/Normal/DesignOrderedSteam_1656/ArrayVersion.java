package main.Coding.Algorithms.Normal.DesignOrderedSteam_1656;

import java.util.ArrayList;
import java.util.List;

public class ArrayVersion {
    String[] stream;
    int ptr = 1;

    public ArrayVersion(int n) {
        stream = new String[n + 1]; // 1-based indexing
    }

    public List<String> insert(int idKey, String value) {
        List<String> res = new ArrayList<>();
        stream[idKey] = value;
        while (ptr < stream.length && stream[ptr] != null) {
            res.add(stream[ptr]);
            ptr++;
        }
        return res;
    }
}
