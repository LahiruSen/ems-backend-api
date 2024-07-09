package com.lahiru.emsbackendapi.service.impl;

import com.lahiru.emsbackendapi.dto.EmployeeDto;
import com.lahiru.emsbackendapi.entity.Employee;
import com.lahiru.emsbackendapi.exception.ResourceNotFoundException;
import com.lahiru.emsbackendapi.mapper.EmployeeMapper;
import com.lahiru.emsbackendapi.repository.EmployeeRepository;
import com.lahiru.emsbackendapi.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee does not exists with the given ID: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees =  employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee does not exists with the given ID: " + employeeId));
        employee.setFirstName(updatedEmployee.getFirstName() !=null ? updatedEmployee.getFirstName() : employee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName() !=null ? updatedEmployee.getLastName() : employee.getLastName());
        employee.setEmail(updatedEmployee.getEmail() != null ? updatedEmployee.getEmail() : employee.getEmail());

        Employee updatedEmployeeEntity = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeEntity);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee does not exists with the given ID: " + employeeId));
        employeeRepository.deleteById(employeeId);
    }


}
