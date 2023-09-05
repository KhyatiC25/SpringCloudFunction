package com.emp.d;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emp.d.Dao.EmployeeDao;
import com.emp.d.Entity.Employee;

@SpringBootTest
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeDao emp;

    @Test
    public void testsaveEmployeWithGeneratedId() {
        Employee e = new Employee();
        e.setName("Riya");
        e.setDepartment("HR");
        Employee savee = emp.save(e);

        assertNotNull(savee.getId());
        Optional<Employee> retrievedEmployee = emp.findById(savee.getId());

        // Assert that the retrieved entity matches the saved entity
        assertTrue(retrievedEmployee.isPresent());
        assertEquals("Riya", retrievedEmployee.get().getName());
        assertEquals("HR", retrievedEmployee.get().getDepartment());
    }
}
