package main.SomeParticalExamples;


import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;


public class FirstOne {
    public static void main(String[] args) {
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());
    }
}
