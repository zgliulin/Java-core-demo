package com.liulin.io.chapter02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;

/**
 * Create by DbL on 2020/4/22 0022
 */
public class MemoryDemo {
    static String str = "Hello world";
    public static void main(String[] args) {
        // 从内存中读取数据
        ByteArrayInputStream inputStream = new ByteArrayInputStream(str.getBytes());
        // 写出到内存中
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int i=0;
        while((i=inputStream.read()) != -1){
            char c = (char)i;
            outputStream.write(Character.toUpperCase(c));
        }
        System.out.println(outputStream.toString());
    }

}
