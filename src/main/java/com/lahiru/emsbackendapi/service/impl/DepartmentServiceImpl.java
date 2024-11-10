package com.lahiru.emsbackendapi.service.impl;

import com.lahiru.emsbackendapi.dto.DepartmentDto;
import com.lahiru.emsbackendapi.entity.Department;
import com.lahiru.emsbackendapi.exception.ResourceNotFoundException;
import com.lahiru.emsbackendapi.mapper.DepartmentMapper;
import com.lahiru.emsbackendapi.repository.DepartmentRepository;
import com.lahiru.emsbackendapi.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentID) {

        Department department = departmentRepository.findById(departmentID).orElseThrow(
                () -> new ResourceNotFoundException("Departmet does not exist for given Id: " + departmentID)
        );
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {

        List<Department>  departments = departmentRepository.findAll();
        return departments.stream().map(DepartmentMapper::mapToDepartmentDto)
                .collect(Collectors.toList());
    }
}
