package br.edu.ifrs.veranopolis.tads.aula1101.service.repository;

import br.edu.ifrs.veranopolis.tads.aula1101.service.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
    // Métodos de consulta adicionais podem ser adicionados aqui, se necessário
}
