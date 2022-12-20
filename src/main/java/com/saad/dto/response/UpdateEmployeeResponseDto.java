package com.saad.dto.response;

import com.saad.repository.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateEmployeeResponseDto {
    private Long id;
    private Company company;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
}
