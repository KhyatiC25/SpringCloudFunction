package com.emp.d.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.d.Entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    Boolean existsByEmail(String email);

    Employee findByPhoneNumber(String phoneNumber);
}
