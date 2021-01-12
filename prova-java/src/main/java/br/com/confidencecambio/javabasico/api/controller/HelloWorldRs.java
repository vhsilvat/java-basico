package br.com.confidencecambio.javabasico.api.controller;

import br.com.confidencecambio.javabasico.domain.service.HelloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldRs {

    private HelloService service;

    public HelloWorldRs(final HelloService service) {

        this.service = service;
    }

    @GetMapping("/ola-mundo")
    public ResponseEntity<String> olaMundo(@RequestParam(value = "nome", required = false) String nome) {
        var retorno = "Ola " + service.retornaValorValido(nome);
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

}
