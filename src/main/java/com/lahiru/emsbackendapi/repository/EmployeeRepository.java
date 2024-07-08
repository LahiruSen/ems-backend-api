package com.lahiru.emsbackendapi.repository;

import com.lahiru.emsbackendapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
