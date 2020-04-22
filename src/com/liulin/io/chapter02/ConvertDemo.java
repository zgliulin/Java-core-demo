package com.liulin.io.chapter02;

import java.io.*;

/**
 * Create by DbL on 2020/4/22 0022
 */
public class ConvertDemo {
    public static void main(String[] args) {
        try(BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("G:/test.txt"));
            InputStreamReader reader = new InputStreamReader(inputStream,"GBK");
            BufferedReader bf = new BufferedReader(reader);
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("G:/test-9.txt"),"GBK");
            BufferedWriter bw = new BufferedWriter(writer)){
            bw.write(bf.readLine());

        }catch (Exception e){

        }
    }
}
