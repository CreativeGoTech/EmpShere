package com.emp.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.emp.entity.Employee;
import com.emp.repository.EmpRepo;

@Service
public class EmpService {
	
	
	
	@Autowired
	private EmpRepo repo;
	
	public void addEmp(Employee e)
	{
		
		repo.save(e);
	}

	public List<Employee> getAllEmp()
	{
	return repo.findAll();
	}
	
	public Employee getEMpById(long id)
	{
		Optional<Employee> e=repo.findById(  id);
		if(e.isPresent()) {
			return e.get();
		}
		
		return null;
		
	}
	
	public void deleteEMp(int id)
	{
		repo.deleteById((long) id);
	}
	
	
	public void increaseSalaries() {
        List<Employee> employees = repo.findAll();
        for (Employee employee : employees) {
            int currentSalary = employee.getSalary();
            employee.setSalary(currentSalary + 2000);
        }
        repo.saveAll(employees);
    }
    
    @Scheduled(fixedDelay = 60000) // Execute every 10 minutes (600,000 milliseconds)
    public void scheduleSalaryIncrease() {
        increaseSalaries();
    }
	
	
	
	
}
