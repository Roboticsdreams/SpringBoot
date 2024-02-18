package com.thinkconstructivespringbootswagger.service;

import com.thinkconstructivespringbootswagger.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getAllEmployee();
    Optional<Employee> getEmployeeByID(Long empID);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
