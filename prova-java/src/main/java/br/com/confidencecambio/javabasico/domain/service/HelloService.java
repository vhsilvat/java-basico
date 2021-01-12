package br.com.confidencecambio.javabasico.domain.service;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HelloService {

    private static final String VALOR_PADRAO = "Mundo";

    public String retornaValorValido(@Nullable String nome) {
        return Optional.ofNullable(nome).orElse(VALOR_PADRAO);
    }
}
