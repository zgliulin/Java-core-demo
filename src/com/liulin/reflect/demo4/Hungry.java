package com.liulin.reflect.demo4;

public class Hungry {

    private static final Hungry instance = new Hungry();

    private Hungry() {
    }

    public static Hungry getInstance() {
        return instance;
    }

}
