package br.edu.ifrs.veranopolis.tads.aula1101.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home"; // Nome do arquivo HTML sem a extensão .html
    }
}