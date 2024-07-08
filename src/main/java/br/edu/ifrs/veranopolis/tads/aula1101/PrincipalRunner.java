package br.edu.ifrs.veranopolis.tads.aula1101;

import br.edu.ifrs.veranopolis.tads.aula1101.service.entity.Usuario;
import br.edu.ifrs.veranopolis.tads.aula1101.service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class PrincipalRunner implements CommandLineRunner {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        Usuario usuario = new Usuario();
        usuario.setUsuario("admin");
        usuario.setSenha(passwordEncoder.encode("123"));
        usuarioRepository.save(usuario);
        System.out.println("Sistema Startado...");
    }
}
