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
        try {
            int i;
            while (true) {

                Thread.sleep(1);

                UserBean bean = new UserBean();
                bean.setAge(10);
                bean.setName("name");

                System.out.println("bean = " + bean);
                users.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
