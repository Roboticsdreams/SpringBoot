package com.thinkconstructivespringbootswagger.controller;

import com.thinkconstructivespringbootswagger.entity.Employee;
import com.thinkconstructivespringbootswagger.exception.ResourceNotFoundException;
import com.thinkconstructivespringbootswagger.service.IEmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Employee", description = "Employee Api")
@RestController
@RequestMapping("api/v1")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return iEmployeeService.getAllEmployee();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getBookById(@PathVariable(value = "id") Long empId) throws ResourceNotFoundException {
        Employee employee = iEmployeeService.getEmployeeByID(empId).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found for this id :: " + empId)
        );
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) throws ResourceNotFoundException {
        return iEmployeeService.saveEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable(value = "id") Long empId,
            @RequestBody Employee employee
    ) throws ResourceNotFoundException {
        Employee newemployee = iEmployeeService.getEmployeeByID(empId).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found for this id :: " + empId)
        );
        newemployee.setName(employee.getName());
        newemployee.setAddress(employee.getAddress());
        final Employee updatedEmployee = iEmployeeService.saveEmployee(newemployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employee")
    public Map<String, Boolean> deleteEmployee(@RequestBody Employee employee) throws ResourceNotFoundException {
        iEmployeeService.deleteEmployee(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
