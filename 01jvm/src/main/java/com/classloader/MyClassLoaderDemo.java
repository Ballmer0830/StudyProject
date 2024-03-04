package com.classloader;

/**
 * <p>
 * <code>MyClassLoaderDemo</code>
 * </p>
 *
 * @author junbao3
 * 自定义类加载器的演示
 * @date 2024-02-28 10:43
 */
public class MyClassLoaderDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader("D:/code/StudyProject/01jvm/target/classes");
        Class<?> aClass = myClassLoader.loadClass("java.Test");
        System.out.println(aClass);
    }
}
