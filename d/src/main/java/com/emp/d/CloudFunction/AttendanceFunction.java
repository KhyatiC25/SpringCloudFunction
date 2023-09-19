package com.emp.d.CloudFunction;

import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;

import com.emp.d.Service.AttendanceService;

public class AttendanceFunction implements Function<Map<String, Object>, String> {
    @Autowired
    private AttendanceService attendanceService;

    @Override
    public String apply(Map<String, Object> input) {
        String action = (String) input.get("action");
        Integer employeeId = Integer.valueOf((String) input.get("employeeId"));

        if ("clockIn".equals(action)) {
            attendanceService.ClockIn(employeeId);
            return "Clocked in successfully";
        } else if ("clockOut".equals(action)) {
            attendanceService.clockOut(employeeId);
            return "Clocked out successfully";
        } else {
            return "Invalid action";
        }
    }
}
