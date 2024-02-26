package com.demo00;

/**
 * <p>
 * <code>Demo01</code>
 * </p>
 *
 * @author junbao3
 * 比较两种获取类加载的代码
 * @date 2024-02-22 10:28
 * Copyright (C) 2021 IFlyTek. All rights reserved.
 */
public class Demo01 {
    public static void main(String[] args) {
        Class<Demo01> demo01Class = Demo01.class;
        System.out.println(demo01Class);  //class com.demo00.Demo01
        System.out.println(demo01Class.getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2


        Class<? extends Class> aClass = demo01Class.getClass();
        System.out.println(aClass);//class java.lang.Class
        System.out.println(String.class.getClass());//class java.lang.Class
        System.out.println(aClass.getClassLoader());//null

        /*
        任何类  通过.class可以获取到这个类对应的Class对象
        继续getClass 获取的就是java.lang.Class
         */

        /*
        A这个类 不管是点class还是调用getClass 拿到一个Class对象  泛型是A  记录A的一些信息
        Class<A> cl = A.class;

        A的Class对象 再调用getClass 拿到的是A的Class对象类型对应的Class对象，类型就是CLass
        Class<>   class  = cl.getClass

        这个class记录的是Class<A>的一些信息
         */
    }
}
