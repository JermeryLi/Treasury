package com.lining.treasury.test;

import lombok.Data;

/**
 * @author lining
 * @date 2019/4/28
 * @description Person
 */
@Data
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
