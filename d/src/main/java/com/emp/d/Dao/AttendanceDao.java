package com.emp.d.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.d.Entity.AttendanceRecord;

public interface AttendanceDao extends JpaRepository<AttendanceRecord, Integer> {
    AttendanceRecord findFirstByEmployeeIdOrderByDateDescClockInTimeDesc(Integer empId);
}
