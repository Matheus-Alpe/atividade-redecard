package br.com.redecard.classes;

public class Securecode {
	private String tipoRegistro;
	private String numPV;
	private String qtdConsultasRealizadas;
	private String valorTotalConsultasPeriodo;
	private String dataInicioPeriodoConsulta;
	private String dataFimPeriodoConsulta;
	private String valorPorConsulta;
	
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
	public String getQtdConsultasRealizadas() {
		return qtdConsultasRealizadas;
	}
	public void setQtdConsultasRealizadas(String qtdConsultasRealizadas) {
		this.qtdConsultasRealizadas = qtdConsultasRealizadas;
	}
	public String getValorTotalConsultasPeriodo() {
		return valorTotalConsultasPeriodo;
	}
	public void setValorTotalConsultasPeriodo(String valorTotalConsultasPeriodo) {
		this.valorTotalConsultasPeriodo = valorTotalConsultasPeriodo;
	}
	public String getDataInicioPeriodoConsulta() {
		return dataInicioPeriodoConsulta;
	}
	public void setDataInicioPeriodoConsulta(String dataInicioPeriodoConsulta) {
		this.dataInicioPeriodoConsulta = dataInicioPeriodoConsulta;
	}
	public String getDataFimPeriodoConsulta() {
		return dataFimPeriodoConsulta;
	}
	public void setDataFimPeriodoConsulta(String dataFimPeriodoConsulta) {
		this.dataFimPeriodoConsulta = dataFimPeriodoConsulta;
	}
	public String getValorPorConsulta() {
		return valorPorConsulta;
	}
	public void setValorPorConsulta(String valorPorConsulta) {
		this.valorPorConsulta = valorPorConsulta;
	}
	@Override
	public String toString() {
		return "Securecode [tipoRegistro=" + tipoRegistro + ", numPV=" + numPV + ", qtdConsultasRealizadas="
				+ qtdConsultasRealizadas + ", valorTotalConsultasPeriodo=" + valorTotalConsultasPeriodo
				+ ", dataInicioPeriodoConsulta=" + dataInicioPeriodoConsulta + ", dataFimPeriodoConsulta="
				+ dataFimPeriodoConsulta + ", valorPorConsulta=" + valorPorConsulta + "]";
	}
	
	
}
