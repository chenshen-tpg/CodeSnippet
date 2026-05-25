package main.CodingQuestions.Algorithms.Easy.BinaryWatch_401;

import java.util.ArrayList;
import java.util.List;

public class BitWist {

    public static void main(String[] args) {

    }

    /***


     >> is the right shift operator. It shifts the bits of a number to the right by a specified number of positions.
     For example, 8 >> 1 results in 4 because the binary representation of 8 (1000)
     shifted right by 1 becomes 0100 (which is 4). This is often used to divide by powers of two.

     & is the bitwise AND operator. It compares each bit of two numbers and returns a new number whose bits are set to 1 only if both corresponding bits are 1.
     For example, 5 & 3 results in 1 because:
     5 in binary: 101
     3 in binary: 011
     Bitwise AND: 001 (which is 1)
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 1024; ++i) {
            int h = i >> 6;
            int m = i & 63; // Extract the high 4 bits and low 6 bits using bitwise operations
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                ans.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return ans;
    }
}
