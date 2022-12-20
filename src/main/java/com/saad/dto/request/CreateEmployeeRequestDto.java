package com.saad.dto.request;


import com.saad.repository.entity.Company;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateEmployeeRequestDto {
    @NotNull
    private Long identityNumber;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    private Long companyId;
}
