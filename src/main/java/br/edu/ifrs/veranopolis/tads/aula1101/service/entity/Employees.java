package br.edu.ifrs.veranopolis.tads.aula1101.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String jobTitle;
    private double dailySalary;

    // Constructors, getters, setters, equals, and hashCode methods

    public Employees() {
    }

    public Employees(String name, String jobTitle, double dailySalary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.dailySalary = dailySalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getDailySalary() {
        return dailySalary;
    }

    public void setDailySalary(double dailySalary) {
        this.dailySalary = dailySalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return id == employees.id &&
                Double.compare(employees.dailySalary, dailySalary) == 0 &&
                Objects.equals(name, employees.name) &&
                Objects.equals(jobTitle, employees.jobTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, jobTitle, dailySalary);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", dailySalary=" + dailySalary +
                '}';
    }
}