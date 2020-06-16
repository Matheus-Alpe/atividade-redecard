package br.com.redecard.classes;

public class AntecipacoesRAV {
	private String tipoRegistro;
	private String numPV;
	private String numDocumento;
	private String dataLancamento;
	private String valorLancamento;
	private String caracCredito;
	private String banco;
	private String agencia;
	private String contaCorrente;
	private String numRVcorrespondente;
	private String dataRVcorrespondente;
	private String valorCreditoOriginal;
	private String dataVencimentoOriginal;
	private String numParcelasTotal;
	private String valorBruto;
	private String valorTaxaDesconto;
	private String numPVoriginal;
	private String bandeira;
	
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
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	public String getNumRVcorrespondente() {
		return numRVcorrespondente;
	}
	public void setNumRVcorrespondente(String numRVcorrespondente) {
		this.numRVcorrespondente = numRVcorrespondente;
	}
	public String getDataRVcorrespondente() {
		return dataRVcorrespondente;
	}
	public void setDataRVcorrespondente(String dataRVcorrespondente) {
		this.dataRVcorrespondente = dataRVcorrespondente;
	}
	public String getValorCreditoOriginal() {
		return valorCreditoOriginal;
	}
	public void setValorCreditoOriginal(String valorCreditoOriginal) {
		this.valorCreditoOriginal = valorCreditoOriginal;
	}
	public String getDataVencimentoOriginal() {
		return dataVencimentoOriginal;
	}
	public void setDataVencimentoOriginal(String dataVencimentoOriginal) {
		this.dataVencimentoOriginal = dataVencimentoOriginal;
	}
	public String getNumParcelasTotal() {
		return numParcelasTotal;
	}
	public void setNumParcelasTotal(String numParcelasTotal) {
		this.numParcelasTotal = numParcelasTotal;
	}
	public String getValorBruto() {
		return valorBruto;
	}
	public void setValorBruto(String valorBruto) {
		this.valorBruto = valorBruto;
	}
	public String getValorTaxaDesconto() {
		return valorTaxaDesconto;
	}
	public void setValorTaxaDesconto(String valorTaxaDesconto) {
		this.valorTaxaDesconto = valorTaxaDesconto;
	}
	public String getNumPVoriginal() {
		return numPVoriginal;
	}
	public void setNumPVoriginal(String numPVoriginal) {
		this.numPVoriginal = numPVoriginal;
	}
	public String getBandeira() {
		return bandeira;
	}
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	@Override
	public String toString() {
		return "AntecipacoesRAV [tipoRegistro=" + tipoRegistro + ", numPV=" + numPV + ", numDocumento=" + numDocumento
				+ ", dataLancamento=" + dataLancamento + ", valorLancamento=" + valorLancamento + ", caracCredito="
				+ caracCredito + ", banco=" + banco + ", agencia=" + agencia + ", contaCorrente=" + contaCorrente
				+ ", numRVcorrespondente=" + numRVcorrespondente + ", dataRVcorrespondente=" + dataRVcorrespondente
				+ ", valorCreditoOriginal=" + valorCreditoOriginal + ", dataVencimentoOriginal="
				+ dataVencimentoOriginal + ", numParcelasTotal=" + numParcelasTotal + ", valorBruto=" + valorBruto
				+ ", valorTaxaDesconto=" + valorTaxaDesconto + ", numPVoriginal=" + numPVoriginal + ", bandeira="
				+ bandeira + "]";
	}

}
