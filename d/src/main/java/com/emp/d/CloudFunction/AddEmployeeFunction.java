package com.emp.d.CloudFunction;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import com.emp.d.Dao.EmployeeDao;
import com.emp.d.Entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AddEmployeeFunction implements Consumer<String> {
    @Autowired
    private EmployeeDao emp;

    @Override
    public void accept(String empdata) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Employee e = objectMapper.readValue(empdata, Employee.class);

            emp.save(e);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
