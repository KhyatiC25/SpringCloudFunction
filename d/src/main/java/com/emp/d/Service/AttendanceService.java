package com.emp.d.Service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.d.Dao.AttendanceDao;
import com.emp.d.Dao.EmployeeDao;
import com.emp.d.Entity.AttendanceRecord;
import com.emp.d.Entity.Employee;

@Service
public class AttendanceService {
    @Autowired
    private EmployeeDao emp;

    @Autowired
    private AttendanceDao at;

    public void ClockIn(Integer empid) {
        Employee e = emp.findById(empid).orElse(null);
        if (e != null) {
            AttendanceRecord r = new AttendanceRecord();
            r.setEmployee(e);
            r.setDate(LocalDate.now());
            r.setClockIntime(LocalTime.now());
            at.save(r);
        }
    }

    public void clockOut(Integer employeeId) {
        Employee e = emp.findById(employeeId).orElse(null);
        if (e != null) {
            AttendanceRecord r = findLatestRecord(employeeId);
            if (r != null) {
                r.setClockOuttime(LocalTime.now());
                at.save(r);
            }
        }
    }

    public AttendanceRecord findLatestRecord(Integer empid) {
        return at.findFirstByEmployeeIdOrderByDateDescClockInTimeDesc(empid);
    }
}
