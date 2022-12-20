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
@Table(name = "tbl_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "companyId" ,referencedColumnName = "id")
    private Company company;
    @Column(length = 11)
    private Long identityNumber;
    @Column(length = 32)
    private String name;
    @Column(length = 32)
    private String surname;
    private String email;
    @Column(length = 16)
    private String phone;
    private String address;
}
