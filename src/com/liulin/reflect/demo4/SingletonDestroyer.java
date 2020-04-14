package com.liulin.reflect.demo4;

import java.lang.reflect.Constructor;

/**
 * Every oak must be an acorn ...
 * Author : Seven
 */
public class SingletonDestroyer {

    public static void main(String[] args) throws Exception {

        Lazy lazyInstance = Lazy.getInstance();

        Constructor constructor = Lazy.class.getDeclaredConstructor();

        constructor.setAccessible(true);

        Lazy lazyInstanceReflect = (Lazy) constructor.newInstance();//调用不成功.

        System.out.println(lazyInstance  == lazyInstanceReflect); // false

    }
}
