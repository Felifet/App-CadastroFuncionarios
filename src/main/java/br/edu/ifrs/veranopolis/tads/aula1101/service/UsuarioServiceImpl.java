package br.edu.ifrs.veranopolis.tads.aula1101.service;

import br.edu.ifrs.veranopolis.tads.aula1101.service.entity.Usuario;
import br.edu.ifrs.veranopolis.tads.aula1101.service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;





    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByUsuario(user)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base de dados."));

        String[] papeis = usuario.getPapeis();

        return User
                .builder()
                .username(usuario.getUsuario())
                .password(usuario.getSenha())
                .roles(papeis)
                .build();
    }



}
