package com.saad.service;

import com.saad.dto.request.CreateCompanyRequestDto;
import com.saad.dto.request.UpdateCompanyRequestDto;
import com.saad.dto.response.UpdateCompanyResponseDto;
import com.saad.exception.CompanyManagerException;
import com.saad.exception.EmployeeManagerException;
import com.saad.exception.ErrorType;
import com.saad.mapper.ICompanyMapper;
import com.saad.mapper.IEmployeeMapper;
import com.saad.repository.entity.Company;
import com.saad.repository.entity.Employee;
import com.saad.utility.ServiceManager;
import com.saad.repository.ICompanyRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService extends ServiceManager<Company, Long> {
    private final ICompanyRepository companyRepository;
    public CompanyService(ICompanyRepository companyRepository) {
        super(companyRepository);
        this.companyRepository = companyRepository;
    }

    public Boolean createCompany(CreateCompanyRequestDto dto) {
        try{
            Company company = companyRepository.save(ICompanyMapper.INSTANCE.toCompany(dto));
            return true;
        }catch (Exception e){
            try {
                throw new CompanyManagerException(ErrorType.COMPANY_NOT_CREATED);
            } catch (CompanyManagerException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public UpdateCompanyResponseDto updateCompany(UpdateCompanyRequestDto dto, Long id) {
        Optional<Company> company = companyRepository.findOptionalById(id);
        if(company.isPresent()){
            try{
                company.get().setEmail(dto.getEmail());
                company.get().setPhone(dto.getPhone());
                company.get().setAddress(dto.getAddress());
                save(company.get());
                return ICompanyMapper.INSTANCE.toUpdateCompanyResponseDto(company.get());
            }
            catch (Exception e){
                throw new CompanyManagerException(ErrorType.COMPANY_NOT_UPDATED);
            }
        }else{
            throw new CompanyManagerException(ErrorType.COMPANY_NOT_FOUND);
        }

    }

    public Boolean deleteCompany(Long id) {
        Optional<Company> company1 = companyRepository.findOptionalById(id);
        if(company1.isPresent()){
            companyRepository.deleteById(id);
            Optional<Company> company2 = companyRepository.findOptionalById(id);
            if(company2.isEmpty()){
                return true;
            }else{
                try {
                    throw new CompanyManagerException(ErrorType.COMPANY_NOT_DELETED);
                }catch (CompanyManagerException e){
                    throw new RuntimeException(e);
                }
                }
            }else{
            try {
                throw new CompanyManagerException(ErrorType.COMPANY_NOT_FOUND);
            }catch (CompanyManagerException e){
                throw new RuntimeException(e);
            }
        }
    }
}
