package br.edu.ifrs.veranopolis.tads.aula1101.service.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class DailyLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "log_date")
    private LocalDate logDate;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employees employee;

    @Column(name = "full_day")
    private boolean fullDay;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public boolean isFullDay() {
        return fullDay;
    }

    public void setFullDay(boolean fullDay) {
        this.fullDay = fullDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DailyLogs)) return false;
        DailyLogs dailyLogs = (DailyLogs) o;
        return id == dailyLogs.id &&
                fullDay == dailyLogs.fullDay &&
                Objects.equals(logDate, dailyLogs.logDate) &&
                Objects.equals(employee, dailyLogs.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, logDate, employee, fullDay);
    }
}
