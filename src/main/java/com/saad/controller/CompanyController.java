package com.saad.controller;

import com.saad.dto.request.CreateCompanyRequestDto;
import com.saad.dto.request.CreateEmployeeRequestDto;
import com.saad.dto.request.UpdateCompanyRequestDto;
import com.saad.dto.request.UpdateEmployeeRequestDto;
import com.saad.dto.response.UpdateCompanyResponseDto;
import com.saad.dto.response.UpdateEmployeeResponseDto;
import com.saad.repository.entity.Company;
import com.saad.repository.entity.Employee;
import com.saad.service.CompanyService;
import com.saad.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.saad.constants.ApiUrls.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(VERSION+API+WEB+COMPANY)
public class CompanyController {
    private final CompanyService companyService;
    @PostMapping(SAVE)
    public ResponseEntity<Boolean> createCompany(@RequestBody CreateCompanyRequestDto dto){
        return ResponseEntity.ok(companyService.createCompany(dto));
    }
    @PutMapping(UPDATE_COMPANY)
    public ResponseEntity<UpdateCompanyResponseDto> updateCompany(@RequestBody UpdateCompanyRequestDto dto, @PathVariable Long id){
        return ResponseEntity.ok(companyService.updateCompany(dto, id));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Company>> findAllCompany(){
        return ResponseEntity.ok(companyService.findAll());
    }
    @DeleteMapping(DELETE)
    public ResponseEntity<Boolean> deleteCompany(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.deleteCompany(id));
    }
}
