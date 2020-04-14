package com.liulin.reflect.demo3;

/**
 * Create by DbL on 2020/4/12 0012
 */
public class Person extends Object{

    //名字
    public String name;

    //年龄
    private int  age;

    //说话
    public void talk(){
        System.out.println(name +",正在说话");
    }

}
