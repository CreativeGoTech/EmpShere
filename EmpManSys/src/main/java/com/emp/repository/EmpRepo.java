package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Use JpaRepository instead of CrudRepository
import org.springframework.stereotype.Repository;

import com.emp.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {
    // You can add custom query methods or use JpaRepository's methods
}
