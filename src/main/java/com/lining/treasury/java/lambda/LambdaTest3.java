package com.lining.treasury.java.lambda;

import org.junit.Test;

/**
 * @author lining
 */
public class LambdaTest3 {
    @Test
    public void test(){
        MyInterface myInterface = () -> System.out.println(1);
        myInterface.method();
    }
}
