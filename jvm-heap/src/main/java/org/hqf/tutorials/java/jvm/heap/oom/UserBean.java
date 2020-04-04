package org.hqf.tutorials.java.jvm.heap.oom;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserBean {
   private String name;
   private int age;
   private Long[] tempData;

   public UserBean(){
      tempData=new Long[100];
   }

}