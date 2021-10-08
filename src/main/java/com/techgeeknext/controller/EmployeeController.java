package com.techgeeknext.controller;

import com.techgeeknext.data.Employee;
import com.techgeeknext.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get/employees")
    public List<Employee> getEmployees()
    {
        logger.info("------------------------------------------");
        logger.info("---In getEmployees Controller----");
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Integer id)
    {
        logger.info("------------------------------------------");
        logger.info("---In getEmployeeById Controller----");
        return employeeService.getEmployeeById(id);
    }

}
