package com.saad.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String name;
    @Column(length = 12)
    private String title;
    @Column(length = 32)
    private String taxNumber;
    @Column(length = 64)
    private String taxOffice;
    @Column(length = 16)
    private String phone;
    private String address;
    private String email;
}
