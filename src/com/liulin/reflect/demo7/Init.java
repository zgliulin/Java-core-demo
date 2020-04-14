package com.liulin.reflect.demo7;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Every oak must be an acorn ...
 * Author : Seven
 */
public class Init {

    public static void main(String[] args) throws Exception {

        //  模拟解析xml   拿到 beanConfigs
        List<BeanConfig> beanConfigs = parseXmltoBeanConfig();
        //循环
        for (BeanConfig tmpconfig : beanConfigs) {
            if (null != tmpconfig.getClazz()) {
                //拿到clazz
                Class clazz = Class.forName(tmpconfig.getClazz());
                if (null != tmpconfig.getFactoryMethod())
                {
                    //基于Class对象获取method对象
                    Method method = clazz.getDeclaredMethod(tmpconfig.getFactoryMethod());
                    IOCContainer.putBean(tmpconfig.getId(), method.invoke(null));

                } else {    //构造器创建bean实例
                    IOCContainer.putBean(tmpconfig.getId(), clazz.newInstance());
                }
            } else if(null != tmpconfig.getFactoryBean()) {
                //从容器中拿到实体bean
                Object obj = IOCContainer.getBean( tmpconfig.getFactoryBean());
                Method method = obj.getClass().getDeclaredMethod(tmpconfig.getFactoryMethod());
                IOCContainer.putBean(tmpconfig.getId(),  method.invoke(obj));
            }else{
                System.out.println("不知道在搞什么鬼.2个核心的配置都没有!");
            }
        }
    }

    /**
     * 模拟一个解析XML过程
     *
     * @return
     */
    private static List<BeanConfig> parseXmltoBeanConfig() {

        List<BeanConfig> beanConfigs = new ArrayList<BeanConfig>();
        BeanConfig beanConfig1 = new BeanConfig();
        beanConfig1.setClazz("com.liulin.reflect.demo6.A");
        beanConfig1.setId("a");
        beanConfigs.add(beanConfig1);

        BeanConfig beanConfig2 = new BeanConfig();
        beanConfig2.setClazz("com.liulin.reflect.demo6.A");
        beanConfig2.setId("b");
        beanConfig2.setFactoryMethod("createBObj");
        beanConfigs.add(beanConfig2);

        BeanConfig beanConfig3 = new BeanConfig();
        beanConfig3.setId("c");
        beanConfig3.setFactoryBean("a");
        beanConfig3.setFactoryMethod("createCObj");
        beanConfigs.add(beanConfig3);

        return beanConfigs;
    }
}
