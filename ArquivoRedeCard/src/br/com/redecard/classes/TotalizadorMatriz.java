package br.com.redecard.classes;

public class TotalizadorMatriz {
	
	private String tpRegistro;
	private String numeroMatriz;
	private String quantidadeResumosMatriz;
	private String valorTotalCreditosNormais;
	private String quantidadeCreditosAntecipados;
	private String valorTotalAntecipados;
	private String quantidadeAjusteCredito;
	private String valorTotalAjusteCredito;
	private String quantidadeAjusteDebito;
	private String valorTotalAjusteDebito;
	
	public String getTpRegistro() {
		return tpRegistro;
	}
	public void setTpRegistro(String tpRegistro) {
		this.tpRegistro = tpRegistro;
	}
	public String getNumeroMatriz() {
		return numeroMatriz;
	}
	public void setNumeroMatriz(String numeroMatriz) {
		this.numeroMatriz = numeroMatriz;
	}
	public String getQuantidadeResumosMatriz() {
		return quantidadeResumosMatriz;
	}
	public void setQuantidadeResumosMatriz(String quantidadeResumosMatriz) {
		this.quantidadeResumosMatriz = quantidadeResumosMatriz;
	}
	public String getValorTotalCreditosNormais() {
		return valorTotalCreditosNormais;
	}
	public void setValorTotalCreditosNormais(String valorTotalCreditosNormais) {
		this.valorTotalCreditosNormais = valorTotalCreditosNormais;
	}
	public String getQuantidadeCreditosAntecipados() {
		return quantidadeCreditosAntecipados;
	}
	public void setQuantidadeCreditosAntecipados(String quantidadeCreditosAntecipados) {
		this.quantidadeCreditosAntecipados = quantidadeCreditosAntecipados;
	}
	public String getValorTotalAntecipados() {
		return valorTotalAntecipados;
	}
	public void setValorTotalAntecipados(String valorTotalAntecipados) {
		this.valorTotalAntecipados = valorTotalAntecipados;
	}
	public String getQuantidadeAjusteCredito() {
		return quantidadeAjusteCredito;
	}
	public void setQuantidadeAjusteCredito(String quantidadeAjusteCredito) {
		this.quantidadeAjusteCredito = quantidadeAjusteCredito;
	}
	public String getValorTotalAjusteCredito() {
		return valorTotalAjusteCredito;
	}
	public void setValorTotalAjusteCredito(String valorTotalAjusteCredito) {
		this.valorTotalAjusteCredito = valorTotalAjusteCredito;
	}
	public String getQuantidadeAjusteDebito() {
		return quantidadeAjusteDebito;
	}
	public void setQuantidadeAjusteDebito(String quantidadeAjusteDebito) {
		this.quantidadeAjusteDebito = quantidadeAjusteDebito;
	}
	public String getValorTotalAjusteDebito() {
		return valorTotalAjusteDebito;
	}
	public void setValorTotalAjusteDebito(String valorTotalAjusteDebito) {
		this.valorTotalAjusteDebito = valorTotalAjusteDebito;
	}
	@Override
	public String toString() {
		return "TotalizadorMatriz [tpRegistro=" + tpRegistro + ", numeroMatriz=" + numeroMatriz
				+ ", quantidadeResumosMatriz=" + quantidadeResumosMatriz + ", valorTotalCreditosNormais="
				+ valorTotalCreditosNormais + ", quantidadeCreditosAntecipados=" + quantidadeCreditosAntecipados
				+ ", valorTotalAntecipados=" + valorTotalAntecipados + ", quantidadeAjusteCredito="
				+ quantidadeAjusteCredito + ", valorTotalAjusteCredito=" + valorTotalAjusteCredito
				+ ", quantidadeAjusteDebito=" + quantidadeAjusteDebito + ", valorTotalAjusteDebito="
				+ valorTotalAjusteDebito + "]";
	}
	
	
}
