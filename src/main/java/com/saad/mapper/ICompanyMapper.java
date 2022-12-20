package com.saad.mapper;

import com.saad.dto.request.CreateCompanyRequestDto;
import com.saad.dto.request.CreateEmployeeRequestDto;
import com.saad.dto.request.UpdateCompanyRequestDto;
import com.saad.dto.request.UpdateEmployeeRequestDto;
import com.saad.dto.response.UpdateCompanyResponseDto;
import com.saad.dto.response.UpdateEmployeeResponseDto;
import com.saad.repository.entity.Company;
import com.saad.repository.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ICompanyMapper {
    ICompanyMapper INSTANCE = Mappers.getMapper(ICompanyMapper.class);
    Company toCompany(final CreateCompanyRequestDto dto);
    Company toCompany(final UpdateCompanyRequestDto dto);

    UpdateCompanyResponseDto toUpdateEmployeeResponseDto(Company company);

    UpdateCompanyResponseDto toUpdateCompanyResponseDto(Company company);
}
