package com.saad.controller;

import com.saad.dto.request.CreateEmployeeRequestDto;
import com.saad.dto.request.UpdateEmployeeRequestDto;
import com.saad.dto.response.UpdateEmployeeResponseDto;
import com.saad.repository.entity.Employee;
import com.saad.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.saad.constants.ApiUrls.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(VERSION+API+WEB+EMPLOYEE)
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping(SAVE)
    public ResponseEntity<Boolean> createEmployee(@RequestBody CreateEmployeeRequestDto dto){
        return ResponseEntity.ok(employeeService.createEmployee(dto));
    }
    @PutMapping(UPDATE_EMPLOYEE)
    public ResponseEntity<UpdateEmployeeResponseDto> updateEmployee(@RequestBody UpdateEmployeeRequestDto dto, @PathVariable @Valid Long identityNumber){
        return ResponseEntity.ok(employeeService.updateEmployee(dto, identityNumber));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Employee>> findAllEmployee(){
        return ResponseEntity.ok(employeeService.findAll());
    }
    @DeleteMapping(DELETE)
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long identityNumber) {
        return ResponseEntity.ok(employeeService.deleteEmployee(identityNumber));
    }
}
