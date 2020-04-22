package com.liulin.io.chapter02;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Create by DbL on 2020/4/22 0022
 */
public class ReadWriterDemo {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("G:/test.txt");
             FileWriter writer = new FileWriter("G:/test-8.txt")) {
            int len = 0;
            char[] by = new char[1024];
            while ((len = reader.read(by)) != -1) {
                writer.write(by,0,len);
            }
        } catch (Exception e) {

        }
    }
}
