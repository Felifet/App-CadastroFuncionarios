package br.edu.ifrs.veranopolis.tads.aula1101.service;

import br.edu.ifrs.veranopolis.tads.aula1101.service.entity.DailyLogs;
import br.edu.ifrs.veranopolis.tads.aula1101.service.entity.Employees;
import br.edu.ifrs.veranopolis.tads.aula1101.service.repository.DailyLogsRepository;
import br.edu.ifrs.veranopolis.tads.aula1101.service.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyLogsService {

    @Autowired
    private DailyLogsRepository dailyLogsRepository;

    @Autowired
    private EmployeesRepository employeesRepository;

    public void saveDailyLog(DailyLogs dailyLog, int employeeId) {
        Employees employee = employeesRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        dailyLog.setEmployee(employee);

        dailyLogsRepository.save(dailyLog);
    }

    public List<DailyLogs> findAll() {
        return dailyLogsRepository.findAll();
    }
}
