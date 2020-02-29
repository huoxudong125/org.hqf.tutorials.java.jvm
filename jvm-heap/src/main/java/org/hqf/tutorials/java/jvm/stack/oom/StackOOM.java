package org.hqf.tutorials.java.jvm.stack.oom;

public class StackOOM {
    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        try {
            recursion.recursionself();
        } catch (Throwable e) {
            System.out.println("current value :" + recursion.currentValue);
            throw e;
        }
    }

}
