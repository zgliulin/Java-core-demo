package com.liulin.reflect.demo2;

/**
 * Create by DbL on 2020/4/12 0012
 */
public class Excel implements Office {
    @Override
    public void toPDF() {
        System.out.println("Excel to PDF");
    }
}
