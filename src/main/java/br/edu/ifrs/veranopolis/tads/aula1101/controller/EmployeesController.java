package br.edu.ifrs.veranopolis.tads.aula1101.controller;

import br.edu.ifrs.veranopolis.tads.aula1101.service.entity.Employees;
import br.edu.ifrs.veranopolis.tads.aula1101.service.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private EmployeesRepository employeesRepository;

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employees> employeesList = (List<Employees>) employeesRepository.findAll();
        model.addAttribute("employees", employeesList);
        return "employees-list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employees());
        return "employee-form";
    }

    @PostMapping("/new")
    public String saveEmployee(@ModelAttribute Employees employee) {
        employeesRepository.save(employee);
        return "redirect:/employees/list";
    }
}