package com.lining.treasury.java.stream;

import com.lining.treasury.java.lambda.methodReference.Employee;
import com.lining.treasury.java.lambda.methodReference.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author lining
 */
public class SteamAPITest3 {
    @Test
    public void test() {
        //
        List<Employee> employees = EmployeeData.getEmployees();
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 15);
        boolean anyMatch = employees.stream().anyMatch(e -> e.getAge() > 15);

    }

    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(1, 23, 4, 45, 5);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
