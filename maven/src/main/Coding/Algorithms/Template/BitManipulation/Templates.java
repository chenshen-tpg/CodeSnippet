package main.Coding.Algorithms.Template.BitManipulation;

public class Templates {
    public static void main(String[] args) {

    }


    //(1) Packing and Unpacking Data (e.g., RGB Colors)
    public void RBG () {
        int r = 120, g = 200, b = 255;
        int rgb = (r << 16) | (g << 8) | b; // Pack
        int red = (rgb >> 16) & 0xFF;       // Unpack red
        int green = (rgb >> 8) & 0xFF;      // Unpack green
        int blue = rgb & 0xFF;              // Unpack blue
    }

    //(2) Checking if a Number is Even or Odd
    public void checkingEvenOrOdd(){
        int num = 99;
        System.out.println((num & 1) == 0);
    }

    //(3) Swapping Two Numbers Without a Temp Variable
    public void swappingNums () {
        int a = 1;
        int b = 2;
        int c = 3;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
    //(4) Efficient Multiplication/Division by Powers of Two
    public void Division () {
        int x = 0;
        //Multiply by 8
        System.out.println(x << 3);
        //Divide by 4
        System.out.println(x >> 2);
    }
    //(5) Setting, Clearing, and Toggling Bits

    public void noSure() {
        int x = 0;
//        Set 3rd bit:
        x |= (1 << 2);
//        Clear 3rd bit:
        x &= ~(1 << 2);
//        Toggle 3rd bit:
        x ^= (1 << 2);
    }

//    (6) Bitmasking for Permissions/Flags
//    Suppose you have flags: READ=1, WRITE=2, EXECUTE=4
    public void permission() {
        int READ = 0, WRITE = 0;
        int permissions = READ | WRITE; // Grant read and write
        boolean canWrite = (permissions & WRITE) != 0;
    }
//    (7) Counting Set Bits (Hamming Weight)
    public void counting() {
        int x = 1;
        Integer.bitCount(x);
    }

//    (8) Extracting Specific Bits
    public void specificBit() {
        int x = 0;
        System.out.println( x & 0xF);
        System.out.println((x >> 4) & 0xF);
    }
}
