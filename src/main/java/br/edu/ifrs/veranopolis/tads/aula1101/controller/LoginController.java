package br.edu.ifrs.veranopolis.tads.aula1101.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() throws IOException {
        return "/login.html";
    }

}
