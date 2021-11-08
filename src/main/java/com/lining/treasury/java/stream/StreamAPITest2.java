package com.lining.treasury.java.stream;

import com.lining.treasury.java.lambda.methodReference.Employee;
import com.lining.treasury.java.lambda.methodReference.EmployeeData;
import org.junit.Test;

import java.util.List;
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
}
