package com.thinkconstructivespringbootswagger.repository;

import com.thinkconstructivespringbootswagger.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
