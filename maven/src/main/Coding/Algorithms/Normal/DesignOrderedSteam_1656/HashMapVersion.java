package main.Coding.Algorithms.Normal.DesignOrderedSteam_1656;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapVersion {
    int index = 1;
    Map<Integer, String> hm;
    public HashMapVersion(int n) {
        hm = new HashMap();
    }

    public List<String> insert(int idKey, String value) {
        List<String> li = new ArrayList();
        hm.put(idKey, value);
        while (hm.containsKey(index)) {
            li.add(hm.get(index));
            index++;
        }
        return li;
    }
}
