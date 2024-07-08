package br.edu.ifrs.veranopolis.tads.aula1101.config;

import br.edu.ifrs.veranopolis.tads.aula1101.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(usuarioService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> {
                    requests
                            .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                            .requestMatchers("/employees/**", "/dailyLogs/**").authenticated()
                            .anyRequest().authenticated();
                })
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true) // Redireciona para /home após login bem-sucedido
                        .permitAll()
                        .failureUrl("/login?error=true")
                        .usernameParameter("usuario")
                        .passwordParameter("senha")
                )
                .logout(LogoutConfigurer::permitAll)
                .userDetailsService(usuarioService)
                .headers(headers -> headers.frameOptions().sameOrigin())
                .httpBasic().disable();

        return http.build();
    }
}
