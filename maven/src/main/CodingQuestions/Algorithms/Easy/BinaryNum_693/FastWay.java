package main.CodingQuestions.Algorithms.Easy.BinaryNum_693;

public class FastWay {
    public static void main(String[] args) {

    }
    
    public boolean hasAlternatingBits(int n) {
        int temp = (n >> 1) + n;
        return (temp & temp + 1) == 0;
    }

}
