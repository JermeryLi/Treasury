package com.lining.treasury.java.lambda.methodReference;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author lining
 * 方法引用 使用示例
 */
public class MethodReferenceTest {

    @Test
    public void test() {
        Consumer<String> consumer1 = str -> System.out.println(str);
        consumer1.accept("北京");

        PrintStream ps = System.out;
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("beijing");
    }


    @Test
    public void test2() {
        Employee employee = new Employee(1001, "tom", 23, 5600);
        Supplier<String> supplier = () -> employee.getName();
        System.out.println(supplier.get());

        Supplier<String> supplier1 = employee::getName;
        System.out.println(supplier1.get());

    }

    @Test
    public void test3() {
        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator1.compare(11, 12));


        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println(comparator2.compare(11, 10));
    }

    @Test
    public void test4() {
        Function<Double, Long> function1 = d -> Math.round(d);
        System.out.println(function1.apply(12.3));

        Function<Double, Long> function2 = Math::round;
        System.out.println(function2.apply(12.6));
    }

    @Test
    public void test5() {
        Comparator<String> comparator1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(comparator1.compare("abc", "abd"));

        Comparator<String> comparator2 = String::compareTo;
        System.out.println(comparator2.compare("abc", "abc"));
    }

    @Test
    public void test6() {
        BiPredicate<String, String> pre1 = (s1, s2) -> s1.equals(s2);
        System.out.println(pre1.test("acx", "acx"));

        BiPredicate<String, String> pre2 = String::equals;
        System.out.println(pre2.test("scv", "scs"));
    }

    @Test
    public void Test7() {
        Employee employee = new Employee(1002, "lining", 23, 8000);
        Function<Employee, String> function = e -> e.getName();
        System.out.println(function.apply(employee));

        Function<Employee, String> function1 = Employee::getName;
        System.out.println(function1.apply(employee));
    }
}
