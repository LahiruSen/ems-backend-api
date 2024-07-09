package com.lahiru.emsbackendapi.service.impl;

import com.lahiru.emsbackendapi.dto.EmployeeDto;
import com.lahiru.emsbackendapi.entity.Employee;
import com.lahiru.emsbackendapi.mapper.EmployeeMapper;
import com.lahiru.emsbackendapi.repository.EmployeeRepository;
import com.lahiru.emsbackendapi.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
