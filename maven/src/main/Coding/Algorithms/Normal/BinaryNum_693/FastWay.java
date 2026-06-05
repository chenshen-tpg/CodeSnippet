package main.Coding.Algorithms.Normal.BinaryNum_693;

public class FastWay {
    public static void main(String[] args) {

    }
    
    public boolean hasAlternatingBits(int n) {
        int temp = (n >> 1) + n;
        return (temp & temp + 1) == 0;
    }

}
