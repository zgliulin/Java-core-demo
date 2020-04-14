package com.liulin.reflect.demo6;

public class A {

    public A() {
        System.out.println("A 无参构造器被调用了.");
    }

    public static B createBObj() {
        System.out.println("A 的静态方法 createBObj 被调用了.");
        return new B();
    }

      public C createCObj() {
        System.out.println("A 的实例方法 createCObj 被调用了.");
        return new C();
    }

}
