package com.lining.treasury.java.lambda.ConstructorReference;

import com.lining.treasury.java.lambda.methodReference.Employee;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author lining
 * 构造器引用 使用示例
 */
public class ConstructorReferenceTest {
    @Test
    public void test() {
        Supplier<Employee> supplier = () -> new Employee();
        supplier.get();

        Supplier<Employee> supplier1 = Employee::new;
        supplier1.get();
    }

    @Test
    public void test2() {
        Function<Integer, Employee> function = id -> new Employee(id);
        System.out.println(function.apply(11).getId());

        Function<Integer, Employee> function11 = Employee::new;
        System.out.println(function11.apply(12).getId());
    }

    @Test
    public void test3() {
        BiFunction<Integer, String, Employee> biFunction = (id, name) -> new Employee(id, name);
        System.out.println(biFunction.apply(11, "lining").getName());

        BiFunction<Integer, String, Employee> biFunction2 = Employee::new;
        System.out.println(biFunction2.apply(11, "111").getName());
    }

    @Test
    public void test4() {
        Function<Integer, String[]> function1 = length -> new String[length];
        //数组引用
        Function<Integer, String[]> function2 = String[]::new;
    }
}


