package br.com.confidencecambio.javabasico.domain.service;

import br.com.confidencecambio.javabasico.domain.constants.Const;
import br.com.confidencecambio.javabasico.domain.response.ImcResponseObject;
import br.com.confidencecambio.javabasico.domain.model.Imc;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

/**
 * @author vhsilvat@gmail.com
 */
@Service
public class ImcService {

	/**
	 * Recebe um objeto contendo os valores de peso e altura
	 * e realiza o cálculo de imc conforme a fórmula.
	 *
	 * @param imc objeto com os valores de peso a altura
	 * @return response object com valor do imc e categoria de peso
	 */
	public ImcResponseObject calcularImc(@NonNull Imc imc) {

		double result = 0;
		result = imc.getPeso() / (Math.pow(imc.getAltura(), 2));

		return new ImcResponseObject(decimalDuasCasas(result), status(result));
	}

	/**
	 * Formata um valor númerico decimal para que este contenha
	 * apenas 2 casas após o ponto flutuante.
	 *
	 * @param value valor a ser formatado
	 * @return valor decimal com duas casas após ponto flutuante
	 */
	public static String decimalDuasCasas(double value) {
		DecimalFormat df = new DecimalFormat("00.00");
		return df.format(value);
	}

	/**
	 * Recebe o resultado do calculo de imc e retorna a categoria de peso
	 * conforme a tabela de imc.
	 *
	 * @param result resultado do calculo de imc
	 * @return categoria de peso
	 */
	public static String status(double result) {

		String status = "";
		if (result <= 18.5) {
			status = Const.MAGREZA;
		} else if (result <= 24.9) {
			status = Const.NORMAL;
		} else if (result <= 29.9) {
			status = Const.SOBREPESO;
		} else if (result <= 39.9) {
			status = Const.OBESIDADE;
		} else {
			status = Const.OBESIDADE_SEVERA;
		}

		return status;
	}
}
