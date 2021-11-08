package com.lining.treasury.java.lambda.methodReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lining
 */
public class EmployeeData {
    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(1001,"alias",11,1000));
        list.add(new Employee(1002,"bob",11,1000));
        list.add(new Employee(1003,"cli",11,1000));
        list.add(new Employee(1004,"dof",11,1000));
        list.add(new Employee(1005,"ford",11,1000));
        list.add(new Employee(1006,"green",11,10000));
        return list;
    }
}
