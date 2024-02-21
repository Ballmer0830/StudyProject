package com.demo01;

import org.junit.Test;

/**
 * <p>
 * <code>ByteCodeInterView</code>
 * </p>
 *
 * @author junbao3
 * TODO
 * @date 2024/2/3 14:21
 */
public class ByteCodeInterView {
    @Test
    public void typeTest(){
        Integer i1 = 10;
        Integer i2 = 10;
        System.out.println(i1 == i2);//true

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4);//false

        Boolean b1 = true;
        Boolean b2 = true;
        System.out.println(b1 == b2);//true

        Double d1=1.00;
        Double d2=1.00;
        System.out.println(d1==d2);//false

        System.out.println(inc());
    }

    public int mathTest(){
        int k = 1 ;
        k = k++;
        return k;
    }

    public int mathTest2(){
        int k = 1 ;
        k = ++k;
        return k;
    }

    public int inc(){
        int x;
        try{
            x=1;
            int i = 1/0;
        }catch (Exception e){
            x = 2;
        }finally {
            x = 3;
        }
        return x;
    }
}
