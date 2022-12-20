package com.saad.mapper;

import com.saad.dto.request.CreateEmployeeRequestDto;
import com.saad.dto.request.UpdateEmployeeRequestDto;
import com.saad.dto.response.UpdateEmployeeResponseDto;
import com.saad.repository.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IEmployeeMapper {
    IEmployeeMapper INSTANCE = Mappers.getMapper(IEmployeeMapper.class);
    Employee toEmployee(final CreateEmployeeRequestDto dto);
    Employee toEmployee(final UpdateEmployeeRequestDto dto);

    UpdateEmployeeResponseDto toUpdateEmployeeResponseDto(Employee employee);
}
