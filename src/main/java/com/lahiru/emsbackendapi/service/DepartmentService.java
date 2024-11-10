package com.lahiru.emsbackendapi.service;

import com.lahiru.emsbackendapi.dto.DepartmentDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(Long departmentId);

    List<DepartmentDto> getAllDepartments();
}
