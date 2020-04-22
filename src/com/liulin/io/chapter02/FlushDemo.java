package com.liulin.io.chapter02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * Create by DbL on 2020/4/22 0022
 */
public class FlushDemo {
    public static void main(String[] args) {
        try(BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("G:/test-4.txt"));){
            outputStream.write("Hello World".getBytes());
            outputStream.close();
        }catch (Exception e){

        }
    }

}
