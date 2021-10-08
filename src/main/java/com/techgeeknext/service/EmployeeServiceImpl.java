package com.techgeeknext.service;

import com.techgeeknext.caching.annotation.CustomEmployeeCachingAnnotation;
import com.techgeeknext.data.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private List<Employee> employees = new ArrayList<>();

    /**
     * Method to get the employee default values
     * First time, it'' get from database
     * Next time onwards it will get it from Cache
     *
     * @return employees
     */
    @Override
    @Cacheable("employees")
    public List<Employee> getEmployees() {
        retrieveDataFromDatabase();
        logger.info("----Getting employee data from database.----");
        return employees;
    }

    /**
     * Create static employees data
     * @param employees
     */
    private void createEmployeesData(List<Employee> employees) {
        employees.add(Employee.builder().id(1).name("TechGeekNextUser1").role("Admin").build());
        employees.add(Employee.builder().id(2).name("TechGeekNextUser2").role("User").build());
        employees.add(Employee.builder().id(3).name("TechGeekNextUser3").role("Supervisor").build());
    }

    @Override
    @CustomEmployeeCachingAnnotation
    public Employee getEmployeeById(Integer employeeId) {
        retrieveDataFromDatabase();
        logger.info("----Getting employee data from database.----");
        return employees.get(employeeId);
    }

    /**
     * Added sleep for 4 second to mimic for database call
     */
    private void retrieveDataFromDatabase() {
        try {
            createEmployeesData(employees);
            logger.info("----Sleep for 4 Secs.. to mimic like it's a backend call.-----");
            Thread.sleep(1000 * 4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
