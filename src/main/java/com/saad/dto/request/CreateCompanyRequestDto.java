package com.saad.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateCompanyRequestDto {
    private String name;
    private String title;
    private String taxNumber;
    private String taxOffice;
    private String phone;
    private String address;
}
