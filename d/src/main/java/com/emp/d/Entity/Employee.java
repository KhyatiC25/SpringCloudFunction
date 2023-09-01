package com.emp.d.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    private Integer id;
    private String name;
    private String department;

}
