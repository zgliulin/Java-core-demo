package com.liulin.reflect.demo2;

/**
 * Create by DbL on 2020/4/12 0012
 */
public class Main {

    public static void main(String[] args) {
        String key = "PPT";
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            Office office = getInstanceReflectByKey(key);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("总计花费时间:" + (endTime - startTime));
    }

    /**
     * 通过传入key 创建不同的对象
     *
     * @param key
     * @return
     */
    public static Office getInstanceByKey(String key) {
        if ("Word".equals(key)) {
            return new Word();
        }

        if ("Excel".equals(key)) {
            return new Excel();
        }

        if ("PPT".equals(key)) {
            return new PPT();
        }

        return null;
    }

    /**
     * 通过反射机制动态的创建
     *
     * @param key
     * @return
     */
    public static Office getInstanceReflectByKey(String key) {
        String packageName = "com.gpseven.corejava.demo2";

        Office office = null;
        try {
            Class clazz = Class.forName(packageName + "." + key);
            office = (Office) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return office;
    }
}

