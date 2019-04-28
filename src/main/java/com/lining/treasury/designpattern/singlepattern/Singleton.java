package com.lining.treasury.designpattern.singlepattern;

/**
 * @author lining
 * @date 2019/4/21
 * @description Singleton
 */
public class Singleton {

    private Singleton() {
        System.out.println("Singleton is created!");
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    /**
     *  不足之处是 无法对instance实例做延迟加载。
     *  如果单例的创建对象过程很慢，而由于instance成员变量是static定义的，
     *  因此在jvm加载单例时,单例对象就会被建立。
     *  这个单列类 在系统中如果扮演其他角色，那么在任何使用这个单例类的地方都会初始化这个单例变量，而不管是否会被用到。
     */
}
