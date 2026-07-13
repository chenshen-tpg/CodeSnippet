package main.Coding.Lib;



public class Pair<K, V> {

    public K element0;
    public V element1;
    public Integer node;
    public Integer weight;



    public K getKey() {
        return element0;
    }

    public V getValue() {
        return element1;
    }

    public Pair(K element0, V element1) {
        this.element0 = element0;
        this.element1 = element1;
    }
    public Pair(Integer node, Integer weight) {
        this.node = node;
        this.weight = weight;
    }
    public Pair(K element01, V element11, int node, int weight) {
        this.element0 = element01;
        this.element1 = element11;
        this.node = node;
        this.weight = weight;
    }
}
