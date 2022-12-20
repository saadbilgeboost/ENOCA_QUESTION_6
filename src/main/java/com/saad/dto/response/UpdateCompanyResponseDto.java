package com.saad.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateCompanyResponseDto {
    private Long id;
    private String name;
    private String title;
    private String phone;
    private String address;
    private String email;
}
