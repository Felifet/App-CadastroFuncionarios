package br.edu.ifrs.veranopolis.tads.aula1101.controller;

import br.edu.ifrs.veranopolis.tads.aula1101.service.DailyLogsService;
import br.edu.ifrs.veranopolis.tads.aula1101.service.entity.DailyLogs;
import br.edu.ifrs.veranopolis.tads.aula1101.service.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dailyLogs")
public class DailyLogsController {

    @Autowired
    private DailyLogsService dailyLogsService;

    @Autowired
    private EmployeesRepository employeesRepository;

    @GetMapping("/list")
    public String listDailyLogs(Model model) {
        model.addAttribute("dailyLogs", dailyLogsService.findAll());
        return "daily_logs-list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("dailyLog", new DailyLogs());
        model.addAttribute("employees", employeesRepository.findAll());
        return "daily_logs-form";
    }

    @PostMapping("/new")
    public String saveDailyLog(@ModelAttribute DailyLogs dailyLog, @RequestParam int employeeId) {
        dailyLogsService.saveDailyLog(dailyLog, employeeId);
        return "redirect:/dailyLogs/list";
    }
}
