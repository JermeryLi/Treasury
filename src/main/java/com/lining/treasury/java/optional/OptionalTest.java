package com.lining.treasury.java.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author lining
 */
public class OptionalTest {
    @Test
    public void test() {
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);
    }

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
    }


    public String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }

    public String getGirlNamePro(Boy boy) {
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                return girl.getName();
            }
        }
        return null;
    }


    @Test
    public void test3() {
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        //会报 空指针
        System.out.println(girlName);
    }


    public String getGirlName2(Boy boy) {
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        Boy boy1 = optionalBoy.orElse(new Boy());
        Girl girl = boy1.getGirl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        return optionalGirl.orElse(new Girl("lining")).getName();
    }

    //使用Optional类的写法
    @Test
    public void test4() {
        String girlName = getGirlName2(null);
        System.out.println(girlName);
    }


}
