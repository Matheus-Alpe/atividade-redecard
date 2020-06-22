package br.com.redecard.classes;

public class AjusteCredito {
	private String tipoRegistro;
	private String pvCreditado;
	private String resumoCredido;
	private String documento;
	private String dtEmissao;
	private String dtCredito;
	private String valorCredito;
	private String credito;
	private String banco;
	private String agencia;
	private String contaCorrente;
	private String codigoMotivoCredito;
	private String mtCredito;
	private String bandeira;
	public String getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public String getPvCreditado() {
		return pvCreditado;
	}
	public void setPvCreditado(String pvCreditado) {
		this.pvCreditado = pvCreditado;
	}
	public String getResumoCredido() {
		return resumoCredido;
	}
	public void setResumoCredido(String resumoCredido) {
		this.resumoCredido = resumoCredido;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getDtEmissao() {
		return dtEmissao;
	}
	public void setDtEmissao(String dtEmissao) {
		this.dtEmissao = dtEmissao;
	}
	public String getDtCredito() {
		return dtCredito;
	}
	public void setDtCredito(String dtCredito) {
		this.dtCredito = dtCredito;
	}
	public String getValorCredito() {
		return valorCredito;
	}
	public void setValorCredito(String valorCredito) {
		this.valorCredito = valorCredito;
	}
	public String getCredito() {
		return credito;
	}
	public void setCredito(String credito) {
		this.credito = credito;
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
	public String getCodigoMotivoCredito() {
		return codigoMotivoCredito;
	}
	public void setCodigoMotivoCredito(String codigoMotivoCredito) {
		this.codigoMotivoCredito = codigoMotivoCredito;
	}
	public String getMtCredito() {
		return mtCredito;
	}
	public void setMtCredito(String mtCredito) {
		this.mtCredito = mtCredito;
	}
	public String getBandeira() {
		return bandeira;
	}
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	@Override
	public String toString() {
		return "AjusteCredito [tipoRegistro=" + tipoRegistro + ", pvCreditado=" + pvCreditado + ", resumoCredido="
				+ resumoCredido + ", documento=" + documento + ", dtEmissao=" + dtEmissao + ", dtCredito=" + dtCredito
				+ ", valorCredito=" + valorCredito + ", credito=" + credito + ", banco=" + banco + ", agencia="
				+ agencia + ", contaCorrente=" + contaCorrente + ", codigoMotivoCredito=" + codigoMotivoCredito
				+ ", mtCredito=" + mtCredito + ", bandeira=" + bandeira + "]";
	}
	
	
}
