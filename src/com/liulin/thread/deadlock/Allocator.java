package com.liulin.thread.deadlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by DbL on 2020/4/21 0021
 */
public class Allocator {
    private List<Object> list = new ArrayList<>();

    /**
     * 申请资源的方法
     * @param from
     * @param to
     * @return
     */
    synchronized boolean apply(Object from,Object to){
        if(list.contains(from) || list.contains(to))return false;
        list.add(from);
        list.add(to);
        return true;
    }

    /**
     * 释放资源的方法
     * @param from
     * @param to
     * @return
     */
    synchronized void free(Object from,Object to){
        list.remove(from);
        list.remove(to);
    }
}
