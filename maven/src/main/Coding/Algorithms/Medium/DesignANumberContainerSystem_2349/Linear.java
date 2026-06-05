package main.Coding.Algorithms.Medium.DesignANumberContainerSystem_2349;

import java.util.TreeMap;

public class Linear {

    TreeMap<Integer, Integer> hm = new TreeMap<>();

    public Linear() {

    }

    public static void main(String[] args) {
        Linear numberContainers = new Linear();
        System.out.println(numberContainers.find(10));
        numberContainers.change(1, 10);
        System.out.println(numberContainers.find(10));
        numberContainers.change(1, 20);
        System.out.println(numberContainers.find(10));
        System.out.println(numberContainers.find(20));
        System.out.println(numberContainers.find(30));
    }

    public void change(int index, int number) {
        hm.put(index, number);
    }

    public int find(int number) {
        for (Integer i : hm.keySet()) {
            if (hm.get(i) == number) {
                return i;
            }
        }
        return -1;
    }
}
