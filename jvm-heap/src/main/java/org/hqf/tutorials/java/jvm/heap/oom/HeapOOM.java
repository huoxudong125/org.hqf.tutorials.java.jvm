package org.hqf.tutorials.java.jvm.heap.oom;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * @author Think
 *
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<UserBean> users = new ArrayList<UserBean>();
        while (true) {
            users.add(new UserBean());
        }
    }
}
