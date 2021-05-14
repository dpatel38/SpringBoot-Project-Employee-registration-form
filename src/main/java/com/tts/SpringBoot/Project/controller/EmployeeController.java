package com.tts.SpringBoot.Project.controller;

import com.tts.SpringBoot.Project.model.Employee;
import com.tts.SpringBoot.Project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String index(Employee employee){
        return "index";
    }

    private Employee employee;

    @GetMapping("/registration_form")
    public String showRegistrationForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "registration_form";
    }

    @PostMapping("/save")
    public String saveEmployee(Employee employee, Model model) {
        employeeRepository.save(new Employee(employee.getFirstName(), employee.getLastName(),
                employee.getAge(), employee.getGender(),
                employee.getJoiningDate(), employee.getSalary(), employee.getDept()));
        model.addAttribute("id",employee.getId());
        model.addAttribute("firstName", employee.getFirstName());
        model.addAttribute("lastName", employee.getLastName());
        model.addAttribute("age", employee.getAge());
        model.addAttribute("gender", employee.getGender());
        model.addAttribute("joiningDate", employee.getJoiningDate());
        model.addAttribute("salary", employee.getSalary());
        model.addAttribute("dept", employee.getDept());
        return "display_form";
    }




}
