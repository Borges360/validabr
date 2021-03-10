package br.com.validabr.validabr_application.controller;

import br.com.validabr.financas.gateway.BaixaCotacaoB3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ApplicationController {


    @RequestMapping("/")
    @ResponseBody
    public String index() {
        System.out.println("Log do servidor de que foi feita uma requisição para '/'.");
        return "Bem-vindo ao Valida BR!";
    }

}
