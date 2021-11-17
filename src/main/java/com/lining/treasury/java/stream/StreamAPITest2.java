package com.lining.treasury.java.stream;

import com.lining.treasury.java.lambda.methodReference.Employee;
import com.lining.treasury.java.lambda.methodReference.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author lining
 */
public class StreamAPITest2 {

    @Test
    public void test() {

        List<Employee> employees = EmployeeData.getEmployees();
        //过滤
        Stream<Employee> employeeStream = employees.stream();
        employeeStream.filter(e -> e.getSalary() > 7000).forEach(e -> System.out.println(e.getName()));
        //截断
        Stream<Employee> employeeStream2 = employees.stream();
        employeeStream2.limit(3).forEach(System.out::println);
        //跳过 skip
        Stream<Employee> employeeStream3 = employees.stream();
        employeeStream3.skip(3).forEach(System.out::println);
        //筛选 去重
        employees.add(new Employee(1000,"aa", 50, 2000));
        employees.add(new Employee(1000,"aa", 50, 2000));
        employees.add(new Employee(1000,"aa", 50, 2000));
        employees.add(new Employee(1000,"aa", 50, 2000));
        employees.add(new Employee(1000,"aa", 50, 2000));
        Stream<Employee> employeeStream4 = employees.stream();
        employeeStream4.distinct().forEach(System.out::println);


    }

    @Test
    public void test2(){
        //映射
        List<String> list = Arrays.asList("aa","bb","cc","dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        //获取员工姓名长度大于3的员工的姓名。

        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> stringStream = employees.stream().map(Employee::getName);
        stringStream.filter(name -> name.length() > 3).forEach(System.out::println);


        employees.stream().filter(employee -> employee.getName().length() > 3).forEach(System.out::println);
        employees.stream().filter(employee -> employee.getName().length() > 3).forEach(employee -> System.out.println(employee.getName()));

    }

    @Test
    public void test3(){
        //排序
        //自然排序
        List<Integer> list = Arrays.asList(12, 12, 34, 13, 1, 4, 65);
        List<Integer> list2 = new ArrayList<>();
        list.stream().sorted().forEach(list2::add);
        list2.stream().forEach(System.out::println);

        //比较器排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);

    }

}
