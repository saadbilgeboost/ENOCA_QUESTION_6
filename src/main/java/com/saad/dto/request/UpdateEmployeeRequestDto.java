package com.saad.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateEmployeeRequestDto {
    private String surname;
    private Long companyId;
    private String email;
    private String phone;
    private String address;
}
