package com.lahiru.emsbackendapi.controller;

import com.lahiru.emsbackendapi.dto.DepartmentDto;
import com.lahiru.emsbackendapi.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping()
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId){
        DepartmentDto department = departmentService.getDepartmentById(departmentId);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        List<DepartmentDto> departmentDtos = departmentService.getAllDepartments();
        return ResponseEntity.ok(departmentDtos);
    }
}
