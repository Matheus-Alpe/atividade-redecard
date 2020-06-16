package br.com.redecard.classes;

public class Creditos {
	private String tipoRegistro;
	private String numPontoVendaCentralizador;
	private String numDocumento;
	private String dataLancamento;
	private String valorLancamento;
	private String caracCredito;
	private String Banco;
	private String Agencia;
	private String contaCorrente;
	private String dataMovimento;
	private String numeroRV;
	private String dataRV;
	private String bandeira;
	private String tipoTransacao;
	private String valorBrutoRV;
	private String valorTaxaDesconto;
	private String numParcelas;
	private String statusCredito;
	private String numPVoriginal;
	
	public String getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public String getNumPontoVendaCentralizador() {
		return numPontoVendaCentralizador;
	}
	public void setNumPontoVendaCentralizador(String numPontoVendaCentralizador) {
		this.numPontoVendaCentralizador = numPontoVendaCentralizador;
	}
	public String getNumDocumento() {
		return numDocumento;
	}
	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}
	public String getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public String getValorLancamento() {
		return valorLancamento;
	}
	public void setValorLancamento(String valorLancamento) {
		this.valorLancamento = valorLancamento;
	}
	public String getCaracCredito() {
		return caracCredito;
	}
	public void setCaracCredito(String caracCredito) {
		this.caracCredito = caracCredito;
	}
	public String getBanco() {
		return Banco;
	}
	public void setBanco(String banco) {
		Banco = banco;
	}
	public String getAgencia() {
		return Agencia;
	}
	public void setAgencia(String agencia) {
		Agencia = agencia;
	}
	public String getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	public String getDataMovimento() {
		return dataMovimento;
	}
	public void setDataMovimento(String dataMovimento) {
		this.dataMovimento = dataMovimento;
	}
	public String getNumeroRV() {
		return numeroRV;
	}
	public void setNumeroRV(String numeroRV) {
		this.numeroRV = numeroRV;
	}
	public String getDataRV() {
		return dataRV;
	}
	public void setDataRV(String dataRV) {
		this.dataRV = dataRV;
	}
	public String getBandeira() {
		return bandeira;
	}
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	public String getTipoTransacao() {
		return tipoTransacao;
	}
	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	public String getValorBrutoRV() {
		return valorBrutoRV;
	}
	public void setValorBrutoRV(String valorBrutoRV) {
		this.valorBrutoRV = valorBrutoRV;
	}
	public String getValorTaxaDesconto() {
		return valorTaxaDesconto;
	}
	public void setValorTaxaDesconto(String valorTaxaDesconto) {
		this.valorTaxaDesconto = valorTaxaDesconto;
	}
	public String getNumParcelas() {
		return numParcelas;
	}
	public void setNumParcelas(String numParcelas) {
		this.numParcelas = numParcelas;
	}
	public String getStatusCredito() {
		return statusCredito;
	}
	public void setStatusCredito(String statusCredito) {
		this.statusCredito = statusCredito;
	}
	public String getNumPVoriginal() {
		return numPVoriginal;
	}
	public void setNumPVoriginal(String numPVoriginal) {
		this.numPVoriginal = numPVoriginal;
	}
	@Override
	public String toString() {
		return "Creditos [tipoRegistro=" + tipoRegistro + ", numPontoVendaCentralizador=" + numPontoVendaCentralizador
				+ ", numDocumento=" + numDocumento + ", dataLancamento=" + dataLancamento + ", valorLancamento="
				+ valorLancamento + ", caracCredito=" + caracCredito + ", Banco=" + Banco + ", Agencia=" + Agencia
				+ ", contaCorrente=" + contaCorrente + ", dataMovimento=" + dataMovimento + ", numeroRV=" + numeroRV
				+ ", dataRV=" + dataRV + ", bandeira=" + bandeira + ", tipoTransacao=" + tipoTransacao
				+ ", valorBrutoRV=" + valorBrutoRV + ", valorTaxaDesconto=" + valorTaxaDesconto + ", numParcelas="
				+ numParcelas + ", statusCredito=" + statusCredito + ", numPVoriginal=" + numPVoriginal + "]";
	}
	
	
	
}
