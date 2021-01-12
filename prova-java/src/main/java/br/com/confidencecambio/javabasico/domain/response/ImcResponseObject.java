package br.com.confidencecambio.javabasico.domain.response;

public class ImcResponseObject {

	private String valorImc;
	private String statusImc;

	public ImcResponseObject(String valorImc, String statusImc) {
		this.valorImc = valorImc;
		this.statusImc = statusImc;
	}

	public String getValorImc() {
		return valorImc;
	}

	public String getStatusImc() {
		return statusImc;
	}
}
