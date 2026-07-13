package main.Coding.Lib;


public class Pair {

    public final int element0;
    public final int element1;

    public Pair(int element0, int element1) {
        this.element0 = element0;
        this.element1 = element1;
    }

    public int getKey() {
        return element0;
    }

    public int getValue() {
        return element1;
    }


}
