package com.saad.repository;

import com.saad.repository.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
Optional<Employee> findOptionalByIdentityNumber(Long identityNumber);
Boolean deleteOptionalByIdentityNumber(Long identityNumber);
}
