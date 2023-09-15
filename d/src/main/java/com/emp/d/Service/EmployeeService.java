package com.emp.d.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.d.Dao.EmployeeDao;
import com.emp.d.Entity.Employee;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao emp;

    public String addEmployee(Employee e) {
        if (emp.existsByEmail(e.getEmail())) {
            return "Email already exists: " + e.getEmail();
        } else {
            emp.save(e);
            return "Employee added successfully";
        }
    }

    public boolean validateOTP(String phoneNumber, String otp) {
        // Retrieve the stored OTP for the given phone number from the database
        Employee employee = emp.findByPhoneNumber(phoneNumber);
        if (employee != null) {
            String storedOTP = employee.getOtp();

            return storedOTP != null && storedOTP.equals(otp);
        } else {
            return false; // Employee with this phone number not found
        }
    }

    public String changePassword(String phoneNumber, String newPassword, boolean isOTPValid) {
        if (isOTPValid) {
            Employee employee = emp.findByPhoneNumber(phoneNumber);
            employee.setPassword(newPassword);
            emp.save(employee);

            employee.setOtp(null);
            emp.save(employee);
            return "Password changed successfully";
        } else {
            return "Invaild otp";
        }
    }

    public void storeOTPInDatabase(String phoneNumber, String otp) {

        Employee employee = emp.findByPhoneNumber(phoneNumber);
        employee.setOtp(otp);
        emp.save(employee);
    }
}
