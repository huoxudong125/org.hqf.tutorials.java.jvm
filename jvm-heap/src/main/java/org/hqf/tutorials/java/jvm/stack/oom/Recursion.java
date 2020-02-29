package org.hqf.tutorials.java.jvm.stack.oom;

public class Recursion {
    public int currentValue = 0;

    public void recursionself() {
        currentValue += 1;
        recursionself();
    }
}
