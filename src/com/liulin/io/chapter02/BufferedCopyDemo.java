package com.liulin.io.chapter02;

import java.io.*;

/**
 * Create by DbL on 2020/4/22 0022
 */
public class BufferedCopyDemo {
    private static File fileSource = new File("G:/mysql-installer-community-5.7.24.0.msi");
    private static File fileTarget = new File("G:/mysql-installer-community-5.7.24.0_copy.msi");

    public void copyWithNormal() {
        try (FileInputStream inputStream = new FileInputStream(fileSource);
             FileOutputStream outputStream = new FileOutputStream(fileTarget)) {
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
        } catch (Exception e) {

        }
    }

    public void copyWithBuffered() {
        try (FileInputStream inputStream = new FileInputStream(fileSource);
             FileOutputStream outputStream = new FileOutputStream(fileTarget);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream)) {
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = bufferedInputStream.read(buf)) != -1) {
                bufferedOutputStream.write(buf, 0, len);
            }
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        BufferedCopyDemo copyDemo = new BufferedCopyDemo();
        long star = System.currentTimeMillis();
        copyDemo.copyWithNormal();
        System.out.println("普通复制耗时：" + (System.currentTimeMillis() - star));

        star = System.currentTimeMillis();
        copyDemo.copyWithBuffered();
        System.out.println("缓冲流赋值耗时：" + (System.currentTimeMillis() - star));

    }
}
