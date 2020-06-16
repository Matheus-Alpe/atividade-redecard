package br.com.redecard.classes;

public class TotalizadorCreditos {
	private String tipoRegistro;
	private String numPV;
	private String brancos;
	private String dataCredito;
	private String valorTotalCreditos;
	private String brancos2;
	private String numBanco;
	private String numAgencia;
	private String numContaCorrente;
	private String dataGeracaoArquivo;
	private String dataCreditoAntecipado;
	private String valorTotalCreditosAntecipados;
	public String getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public String getNumPV() {
		return numPV;
	}
	public void setNumPV(String numPV) {
		this.numPV = numPV;
	}
	public String getBrancos() {
		return brancos;
	}
	public void setBrancos(String brancos) {
		this.brancos = brancos;
	}
	public String getDataCredito() {
		return dataCredito;
	}
	public void setDataCredito(String dataCredito) {
		this.dataCredito = dataCredito;
	}
	public String getValorTotalCreditos() {
		return valorTotalCreditos;
	}
	public void setValorTotalCreditos(String valorTotalCreditos) {
		this.valorTotalCreditos = valorTotalCreditos;
	}
	public String getBrancos2() {
		return brancos2;
	}
	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}
	public String getNumBanco() {
		return numBanco;
	}
	public void setNumBanco(String numBanco) {
		this.numBanco = numBanco;
	}
	public String getNumAgencia() {
		return numAgencia;
	}
	public void setNumAgencia(String numAgenica) {
		this.numAgencia = numAgenica;
	}
	public String getNumContaCorrente() {
		return numContaCorrente;
	}
	public void setNumContaCorrente(String numContaCorrente) {
		this.numContaCorrente = numContaCorrente;
	}
	public String getDataGeracaoArquivo() {
		return dataGeracaoArquivo;
	}
	public void setDataGeracaoArquivo(String dataGeracaoArquivo) {
		this.dataGeracaoArquivo = dataGeracaoArquivo;
	}
	public String getDataCreditoAntecipado() {
		return dataCreditoAntecipado;
	}
	public void setDataCreditoAntecipado(String dataCreditoAntecipado) {
		this.dataCreditoAntecipado = dataCreditoAntecipado;
	}
	public String getValorTotalCreditosAntecipados() {
		return valorTotalCreditosAntecipados;
	}
	public void setValorTotalCreditosAntecipados(String valorTotalCreditosAntecipados) {
		this.valorTotalCreditosAntecipados = valorTotalCreditosAntecipados;
	}
	@Override
	public String toString() {
		return "TotalizadorCreditos [tipoRegistro=" + tipoRegistro + ", numPV=" + numPV + ", brancos=" + brancos
				+ ", dataCredito=" + dataCredito + ", valorTotalCreditos=" + valorTotalCreditos + ", brancos2="
				+ brancos2 + ", numBanco=" + numBanco + ", numAgencia=" + numAgencia + ", numContaCorrente="
				+ numContaCorrente + ", dataGeracaoArquivo=" + dataGeracaoArquivo + ", dataCreditoAntecipado="
				+ dataCreditoAntecipado + ", valorTotalCreditosAntecipados=" + valorTotalCreditosAntecipados + "]";
	}
	
	
	
	
}
