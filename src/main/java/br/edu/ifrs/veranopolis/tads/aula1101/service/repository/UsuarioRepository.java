package br.edu.ifrs.veranopolis.tads.aula1101.service.repository;

import br.edu.ifrs.veranopolis.tads.aula1101.service.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByUsuario(String usuario);
}
