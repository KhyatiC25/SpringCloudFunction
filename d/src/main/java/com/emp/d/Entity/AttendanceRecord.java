package com.emp.d.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "At")
public class AttendanceRecord {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDate date;
    private LocalTime clockInTime;
    private LocalTime clockOutTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getClockIntime() {
        return clockInTime;
    }

    public void setClockIntime(LocalTime clockIntime) {
        this.clockInTime = clockIntime;
    }

    public LocalTime getClockOuttime() {
        return clockOutTime;
    }

    public void setClockOuttime(LocalTime clockOuttime) {
        this.clockOutTime = clockOuttime;
    }

}
