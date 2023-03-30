package com.example.act456.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloConreoller {
    @GetMapping("/hola")
    public String hola(){
        return "hola desde el controlador de saludos";
    }
}
