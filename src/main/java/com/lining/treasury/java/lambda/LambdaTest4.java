package com.lining.treasury.java.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author lining
 *Java内置四大函数时接口
 */
public class LambdaTest4 {
    @Test
    public void test1() {
        happyTime(500, money -> System.out.println("消费" + money + "元"));
    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京","天津","普京","南京");
        List<String> list2 = filterString(list, s -> s.contains("京"));
        for (String s : list2) {
            System.out.println(s);
        }
    }

    /**
     * 根据给定的规则，过滤集合中的字符串。过滤规则由Predicate的方法决定
     * @param list
     * @param pre
     * @return
     */
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
}
