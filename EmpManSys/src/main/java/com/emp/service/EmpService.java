package com.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.emp.entity.Employee;
import com.emp.repository.EmpRepo;

@Service
public class EmpService {

    @Autowired
    private EmpRepo repository;

    // Get all employees
    public List<Employee> getAllEmp() {
        return repository.findAll();
    }

    // Add a new employee
    public void addEmp(Employee e) {
        repository.save(e);
    }

    // Get employee by ID
    public Employee getEMpById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update an existing employee
    public void updateEmp(Employee e) {
        repository.save(e);
    }

    // Delete employee by ID
    public void deleteEMp(Long id) {
        repository.deleteById(id);
    }
}
