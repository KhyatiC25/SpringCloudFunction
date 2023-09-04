package com.emp.d.CloudFunction;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import com.emp.d.Dao.EmployeeDao;
import com.emp.d.Entity.Employee;

public class AddEmployeeFunction implements Consumer<String> {
    @Autowired
    private EmployeeDao emp;

    @Override
    public void accept(String empdata) {
        Employee e = parseEmployeeData(empdata);
        emp.save(e);
    }

    private Employee parseEmployeeData(String empdata) {
        String[] parts = empdata.split(",");
        Employee employee = new Employee();
        employee.setName(parts[0]);
        employee.setDepartment(parts[1]);
        // Set other properties as needed
        return employee;
    }
}
