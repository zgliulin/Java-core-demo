package com.liulin.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Create by DbL on 2020/4/14 0014
 */
public class GenericDemo1 {


    public static void main(String[] args) throws Exception {

//        method(100,"张三");
//        demo1();
        //demo2();
//        com.gpseven.corejava.demo3();
//        demo4();
//
//        demo5
        ArrayList<String> arrayList1 = new ArrayList<String>();
        ArrayList<Number> arrayList2 = new ArrayList<Number>();
        demo5(arrayList1);
        demo5(arrayList2);
//
//        //demo6
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        ArrayList<Number> arrayList4 = new ArrayList<Number>();
        ArrayList<Double> arrayList5 = new ArrayList<Double>();
        ArrayList<String> arrayList55 = new ArrayList<String>();
        demo6(arrayList3);
        demo6(arrayList4);
      //  demo6(arrayList55);
//
//        //demo7
        ArrayList<Integer> arrayList6 = new ArrayList<Integer>();
        ArrayList<Number> arrayList7 = new ArrayList<Number>();
        ArrayList<Double> arrayList8 = new ArrayList<Double>();
        demo7(arrayList6);
        demo7(arrayList7);
//        demo7(arrayList8);


    }

    public static void method(int count, String str) {

        System.out.println("count:" + count);
        System.out.println("str:" + str);

    }


    public static void demo1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(38);
        arrayList.add("zhangsan");
        arrayList.add(new Object());

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).getClass());
        }
    }


    /**
     * 限定类型的集合使用
     */
    public static void demo2() {
       /* ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add(38);
        stringArrayList.add("zhangsan");
        stringArrayList.add(new Object());

        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i).getClass());
        }*/
    }


    /**
     * 泛型只在编译阶段有效.
     * 在编译之后程序会采取去泛型化的措施
     * 正确检验泛型结果后，会将泛型的相关信息擦出
     */
    public static void demo3() {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> stringArrayList = new ArrayList<String>();
        System.out.println(arrayList.getClass());
        System.out.println(stringArrayList.getClass());
        System.out.println(arrayList.getClass() == stringArrayList.getClass());
    }


    public static void demo4() throws Exception {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("zhangsan");
        stringArrayList.add("lisi");
        stringArrayList.add("wangwu");
        System.out.println("操作之前长度:" + stringArrayList.size());

        //反射进行元素的新增
        Class clazz = stringArrayList.getClass();
        Method method = clazz.getDeclaredMethod("add", Object.class);
        method.invoke(stringArrayList, 88);
        System.out.println("操作之后长度:" + stringArrayList.size());

    }

    /**
     * 无边界通配符
     *
     * @param arrayList
     */
    public static void demo5(ArrayList<?> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    /**
     * 上界通配符
     *
     * @param arrayList
     */
    public static void demo6(ArrayList<? extends Number> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    /**
     * 下界通配符
     *
     * @param arrayList
     */
    public static void demo7(ArrayList<? super Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

}
