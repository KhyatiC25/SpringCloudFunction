package com.emp.d.CloudFunction;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;

import com.emp.d.Dao.EmployeeDao;
import com.emp.d.Entity.Employee;

public class etEmployeeFunction implements Function<Integer, Employee> {
    @Autowired
    private EmployeeDao emp;

    @Override
    public Employee apply(Integer id) {
        return emp.findById(id).orElse(null);
    }
}
