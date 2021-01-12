package br.com.confidencecambio.javabasico.api.controller;

import br.com.confidencecambio.javabasico.domain.response.ImcResponseObject;
import br.com.confidencecambio.javabasico.domain.model.Imc;
import br.com.confidencecambio.javabasico.domain.service.ImcService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vhsilvat@gmail.com
 */
@RestController
public class ImcController {

	private final ImcService imcService;

	public ImcController(ImcService imcService) {
		this.imcService = imcService;
	}

	@GetMapping("/calcular-imc")
	@ResponseStatus(HttpStatus.OK)
	public ImcResponseObject calcularImc(@RequestBody Imc imc) {

		return imcService.calcularImc(imc);
	}
}
