package com.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.security.SecureClassLoader;

/**
 * <p>
 * <code>MyClassLoader</code>
 * </p>
 *
 * @author junbao3
 * 自定义类加载器
 * @date 2024-02-28 10:29
 */
public class MyClassLoader extends SecureClassLoader {
    private String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String filePath = this.classPath+name.replace(".","/").concat(".myclass");
        int code;
        try {

            FileInputStream fis = new FileInputStream(filePath);
            fis.read();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((code = fis.read())!=-1){
                bos.write(code);
            }
            byte[] byteArray = bos.toByteArray();
            bos.close();
            return  defineClass(name,byteArray,0,byteArray.length);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
