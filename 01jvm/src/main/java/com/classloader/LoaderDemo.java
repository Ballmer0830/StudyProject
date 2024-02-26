package com.classloader;

import com.sun.java.accessibility.util.EventID;

/**
 * <p>
 * <code>LoaderDemo</code>
 * </p>
 *
 * @author junbao3
 * 展示 不同的类加载器
 * @date 2024-02-21 20:08
 */
public class LoaderDemo {
    public static String a = "aaa";

    public static void main(String[] args) throws ClassNotFoundException {
        //父子关系 AppClassLoader   ->  ExtClassLoader  ->BootStrapClassLoader

        ClassLoader cl1 = LoaderDemo.class.getClassLoader();
        System.out.println("cl1:"+cl1);
        System.out.println("cl1的parent:"+cl1.getParent());
        //BootStrapClassLoader由C++开发 是jvm虚拟机的一部分 本身不是JAVA类 打印是null
        System.out.println("cl1的parent的parent:"+cl1.getParent().getParent());

        System.out.println("-------------------------------------");

        //String 基础类是由BootStrapClassLoader加载的
        ClassLoader cl2 = String.class.getClassLoader();
        System.out.println("cl2:"+cl2);
        //用 app类加载器尝试加载List类，往上找父加载器，有没有加载过，没有，继续往上找，找到顶层加载器，加载过，返回这个类。 这个类是由BootStrapClassLoader加载的
        System.out.println(cl1.loadClass("java.util.List").getClassLoader());
        System.out.println("-------------------------------------");

        //EventID 是由ExtClassLoader加载的
        ClassLoader cl3 = EventID.class.getClassLoader();
        System.out.println("cl3:"+cl3);
        //用 app类加载器尝试加载EventID，往上找父加载器，有没有加载过，没有，继续往上找，找到顶层加载器，加载过，返回这个类。 这个类是由BootStrapClassLoader加载的
        System.out.println(cl1.loadClass("com.sun.java.accessibility.util.EventID").getClassLoader());
        System.out.println("-------------------------------------");

        // java指令可以通过增加-verbose:class -verbose:gc 参数在启动时打印出类加载情况
        // BootStrap Classloader，加载java基础类。这个属性不能在java指令中指定，推断不是由java语言处理。。
        System.out.println("BootStrap ClassLoader加载目录：" + System.getProperty("sun.boot.class.path"));
        // Extention Classloader 加载JAVA_HOME/ext下的jar包。 可通过-D java.ext.dirs另行指定目录
        System.out.println("Extention ClassLoader加载目录：" + System.getProperty("java.ext.dirs"));
        // AppClassLoader 加载CLASSPATH，应用下的Jar包。可通过-D java.class.path另行指定目录
        System.out.println("AppClassLoader加载目录：" + System.getProperty("java.class.path"));
    }
}
