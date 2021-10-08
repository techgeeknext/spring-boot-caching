package com.techgeeknext.service;

import com.techgeeknext.data.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee getEmployeeById(Integer employeeId);
}
