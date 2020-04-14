package com.liulin.reflect.demo2;

/**
 * Create by DbL on 2020/4/12 0012
 */
public class Word implements Office {
    @Override
    public void toPDF() {
        System.out.println("Word to PDF");
    }
}
