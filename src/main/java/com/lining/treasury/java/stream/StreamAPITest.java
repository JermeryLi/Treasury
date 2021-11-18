package com.lining.treasury.java.stream;

import com.lining.treasury.java.lambda.methodReference.Employee;
import com.lining.treasury.java.lambda.methodReference.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author lining
 */
public class StreamAPITest {

    @Test
    public void test() {
        //集合
        List<Employee> employees = EmployeeData.getEmployees();
        //顺序流
        Stream<Employee> stream = employees.stream();
        //并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }
    @Test
    public void test2() {
        //数组
        int[] arr = new int[]{1,2,3,4,5};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "tim");
        Employee e2 = new Employee(1002, "jerry");
        Employee[] employees = new Employee[]{e1, e2};
        Stream<Employee> employeeStream = Arrays.stream(employees);
    }

    @Test
    public void test3() {
        //Stream.of
        Stream<Integer> stream = Stream.of(1,2,3,4,6);
    }

    @Test
    public void test4() {
        //创建无限流
        //迭代
        Stream.iterate(0, t -> t+ 2).limit(10).forEach(System.out::println);

        //生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
