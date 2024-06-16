package com.emp.controller;
import org.springframework.ui.Model;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.emp.entity.Employee;
import com.emp.service.EmpService;

@Controller
public class EmpController {
	
	
	@Autowired
	private EmpService service;

	@GetMapping("/")
	public String home(Model m)
	{
		List<Employee> emp= service.getAllEmp();
		m.addAttribute("emp",emp);
		
		
		return "index";
	}

	@GetMapping("/addemp")
	public String addEmpForm()
	
	{
		return "add_emp";
		
	}
	
	
	@GetMapping("/aboutl")
	public String aEmpForm()
	
	{
		return "about";
		
	}
	
	@GetMapping("/m")
	public String Homeemp()
	
	{
		return "Home1";
		
	}
	

	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session)
	{
		
		System.out.println(e);
		
		service.addEmp(e);
		session.setAttribute("msg", "Employee added successfully...");
		
		
	return "redirect:/";
	}
	
	@GetMapping ("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		
		Employee e=service.getEMpById((long) id);
		m.addAttribute("emp",e);
		return "edit";
	}
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session)
	{
		service.addEmp(e);
		session.setAttribute("msg", "Emp Date Update Successfullyt..");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String  deleteEMp(@PathVariable int id,HttpSession session)
	{         
		
		service.deleteEMp((long) id);
		session.setAttribute("msg", "Emp Date delete Successfullyt..");
		return "redirect:/";
	}
	
}
