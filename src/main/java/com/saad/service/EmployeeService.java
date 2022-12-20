package com.saad.service;


import com.saad.dto.request.CreateEmployeeRequestDto;
import com.saad.dto.request.UpdateEmployeeRequestDto;
import com.saad.dto.response.UpdateEmployeeResponseDto;
import com.saad.exception.EmployeeManagerException;
import com.saad.exception.ErrorType;
import com.saad.mapper.IEmployeeMapper;
import com.saad.repository.ICompanyRepository;
import com.saad.repository.IEmployeeRepository;
import com.saad.repository.entity.Employee;
import com.saad.utility.ServiceManager;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeService extends ServiceManager<Employee, Long> {
    private final IEmployeeRepository employeeRepository;
    private final ICompanyRepository companyRepository;
    public EmployeeService(IEmployeeRepository employeeRepository, ICompanyRepository companyRepository) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }

    public Boolean createEmployee(CreateEmployeeRequestDto dto) {
            try{
                Employee employee = Employee.builder().identityNumber(dto.getIdentityNumber())
                        .name(dto.getName())
                        .surname(dto.getSurname())
                        .build();
                employee.setCompany(companyRepository.findOptionalById(dto.getCompanyId()).get());
                save(employee);
                return true;
            }catch (Exception e){
                try {
                    throw new EmployeeManagerException(ErrorType.EMPLOYEE_NOT_CREATED);
                } catch (EmployeeManagerException ex) {
                    throw new RuntimeException(ex);
                }
            }
    }
    @SneakyThrows
    public UpdateEmployeeResponseDto updateEmployee(UpdateEmployeeRequestDto dto, Long identityNumber){
        Optional<Employee> employee=employeeRepository.findOptionalByIdentityNumber(identityNumber);
        if(employee.isPresent()){
            try{
                employee.get().setSurname(dto.getSurname());
                employee.get().setCompany(companyRepository.findOptionalById(dto.getCompanyId()).get());
                employee.get().setEmail(dto.getEmail());
                employee.get().setPhone(dto.getPhone());
                employee.get().setAddress(dto.getAddress());
                save(employee.get());
                return IEmployeeMapper.INSTANCE.toUpdateEmployeeResponseDto(employee.get());
            }catch (Exception e){
                throw new EmployeeManagerException(ErrorType.EMPLOYEE_NOT_UPDATED);
            }
        }else{
            throw new EmployeeManagerException(ErrorType.EMPLOYEE_NOT_FOUND);
        }
    }
    public Boolean deleteEmployee(Long identityNumber) {
        Optional<Employee>employee1 =employeeRepository.findOptionalByIdentityNumber(identityNumber);
        if(employee1.isPresent()){
            employeeRepository.deleteOptionalByIdentityNumber(identityNumber);
            Optional<Employee> employee2 = employeeRepository.findOptionalByIdentityNumber(identityNumber);
            if(employee2.isEmpty()){
                return true;
            }else{
                try {
                    throw new EmployeeManagerException(ErrorType.EMPLOYEE_NOT_DELETED);
                } catch (EmployeeManagerException e) {
                    throw new RuntimeException(e);
                }
            }
        }else {
            try {
                throw new EmployeeManagerException(ErrorType.EMPLOYEE_NOT_FOUND);
            } catch (EmployeeManagerException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
