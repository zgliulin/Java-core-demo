package com.liulin.io.chapter02;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create by DbL on 2020/4/22 0022
 */
public class FileDemo {
    public static void main(String[] args) {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            String path = bufferedReader.readLine();// 读取用户输入的路径
            File file = new File(path);
            if (file.isDirectory() && file.exists()) {
                // 遍历这个目录下的所有子目录
                fileList(file);
            } else {
                System.out.println("文件路径输入错误");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void fileList(File filePath) {
        File[] files = filePath.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    System.out.println(files[i].getName()); // 输出具体的文件名
                } else {
                    fileList(files[i]);
                }
            }
        }
    }
}
