package br.com.redecard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import br.com.redecard.classes.AVS;
import br.com.redecard.classes.AjusteCredito;
import br.com.redecard.classes.AjusteNETdesagendamentos;
import br.com.redecard.classes.AjustesDebitoViaBanco;
import br.com.redecard.classes.AntecipacoesRAV;
import br.com.redecard.classes.Creditos;
import br.com.redecard.classes.DebitosLiquidados;
import br.com.redecard.classes.DebitosPendentes;
import br.com.redecard.classes.DesagendamentoParcelas;
import br.com.redecard.classes.HeaderArquivo;
import br.com.redecard.classes.HeaderMatriz;
import br.com.redecard.classes.Securecode;
import br.com.redecard.classes.Serasa;
import br.com.redecard.classes.TotalizadorCreditos;
import br.com.redecard.classes.TotalizadorMatriz;
public class LerArquivo {
	//Estou aqui - Rafael
	//Eu tbm estou aqui - Matheus

	public void leitura() throws IOException{
		File arquivo = new File("resources/NEFI_TESTE_1908.txt");
		FileReader fr = new FileReader(arquivo);
		
		BufferedReader bf = new BufferedReader(fr);
		
		while(bf.ready()) {
			String linha = bf.readLine();
			
			String tipo = linha.substring(0, 3);
			
			if(tipo.equals("030")){
				System.out.println("Cabeçalho do Arquivo");
				
				String data = this.retornaData(linha.substring(3, 11));
				String operadora = linha.substring(11, 19);
				String descricao = linha.substring(19, 53);
				String nomeComercial = linha.substring(53, 75);
				String sequenciaMovimento = linha.substring(75, 81);
				String numeroPontoVenda = linha.substring(81, 90);
				String tipoProcessamento = linha.substring(90, 105);
				String versaoArquivo = linha.substring(105, 125);
				
				//************** instanciando obj header
				HeaderArquivo objHeader = new HeaderArquivo();
				objHeader.setTipoRegistro(tipo);
				objHeader.setDataEmissao(data);
				objHeader.setOperadora(operadora);
				objHeader.setDescricaoArquivo(descricao);
				objHeader.setNomeComercial(nomeComercial);
				objHeader.setSequenciaMovimento(sequenciaMovimento);
				objHeader.setNumeroPontoVenda(numeroPontoVenda);
				objHeader.setTipoProcessamento(tipoProcessamento);
				objHeader.setVersaoArquivo(versaoArquivo);
				
				System.out.println(objHeader.toString());
			}
			
			if(tipo.equals("032")){
				System.out.println("Cabeçalho da Matriz");
				
				String numeroPontoVenda = linha.substring(3, 12);
				String nomeComercial = linha.substring(12);
				//************** instanciando obj header matriz
				HeaderMatriz objHM = new HeaderMatriz();
				objHM.setTipoRegistro(tipo);
				objHM.setNumeroPontoVenda(numeroPontoVenda);
				objHM.setNomeComercial(nomeComercial);
				
				System.out.println(objHM.toString());
			}
			if(tipo.equals("034")) {
				System.out.println("Créditos");
				
				String numPontoVendaCentralizador = linha.substring(3, 12);
				String numDocumento = linha.substring(12, 23);
				String dataLancamento = this.retornaData(linha.substring(23, 31));
				String valorLancamento = linha.substring(31, 46);
				String caracCredito = "" + linha.charAt(46);
				String banco = linha.substring(47, 50);
				String agencia = linha.substring(50, 56);
				String contaCorrente = linha.substring(56, 67);
				String dataMovimento  = this.retornaData(linha.substring(67, 75));
				String numeroRV = linha.substring(75, 84);
				String dataRV = this.retornaData(linha.substring(84, 92));
				String bandeira = linha.substring(92, 93);
				String tipoTransacao = this.retornaTipoTransacao(linha.substring(93, 94));
				String valorBrutoRV = linha.substring(94, 109);
				String valorTaxaDesconto = linha.substring(109, 124);
				String numParcelas = linha.substring(124, 129);
				String statusCredito = this.retornaStatusCredito(linha.substring(129, 131));
				String numPVoriginal = linha.substring(131);
				
				//************** instanciando obj creditos
				Creditos cred = new Creditos();
				cred.setTipoRegistro(tipo);
				cred.setNumPontoVendaCentralizador(numPontoVendaCentralizador);
				cred.setNumDocumento(numDocumento);
				cred.setDataLancamento(dataLancamento);
				cred.setValorLancamento(valorLancamento);
				cred.setCaracCredito(caracCredito);
				cred.setBanco(banco);
				cred.setAgencia(agencia);
				cred.setContaCorrente(contaCorrente);
				cred.setDataMovimento(dataMovimento);
				cred.setNumeroRV(numeroRV);
				cred.setDataRV(dataRV);
				cred.setBandeira(bandeira);
				cred.setTipoTransacao(tipoTransacao);
				cred.setValorBrutoRV(valorBrutoRV);
				cred.setValorTaxaDesconto(valorTaxaDesconto);
				cred.setNumParcelas(numParcelas);
				cred.setStatusCredito(statusCredito);
				cred.setNumPVoriginal(numPVoriginal);
				
				System.out.println(cred.toString());
			}
			
			if(tipo.equals("035")) {
				System.out.println("Ajustes NET e Desagendamentos");

				String numPVajustado = linha.substring(3, 12);
				String numRVajustado = linha.substring(12, 21);
				String dataAjuste = this.retornaData(linha.substring(21, 29));
				String valorAjuste = linha.substring(29, 44);
				String caracDebito = linha.substring(44, 45);
				String codMotivoAjuste = linha.substring(45, 47);
				String motivoAjuste = linha.substring(47, 75);
				String numCartao = linha.substring(75, 91);
				String dataTransacaoCV = this.retornaData(linha.substring(91, 99));
				String numRVoriginal = linha.substring(99, 108);
				String numReferenciaCartaFax = linha.substring(108, 123);
				String dataCarta = this.retornaData(linha.substring(123, 131));
				String mesReferencia = linha.substring(131, 137);
				String numPVoriginal = linha.substring(137, 146);
				String dataRVoriginal = this.retornaData(linha.substring(146, 154));
				String valorTransacao = linha.substring(154, 169);
				String caracDouNet = linha.substring(169, 170);
				String dataCredito = this.retornaData(linha.substring(170, 178));
				String novoValorParcela = linha.substring(178, 193);
				String valorOriginalParcela = linha.substring(193, 208);
				String valorBrutoResumoVendaOriginal = linha.substring(208, 223);
				String valorCancelamentoSolicitado = linha.substring(223, 238);
				String numNSU = linha.substring(238, 250);
				String numAutorizacao = linha.substring(250, 256);
				
				
				//************** instanciando obj ajuste e desagendamentos		
				AjusteNETdesagendamentos a = new AjusteNETdesagendamentos();
				
				if(!caracDouNet.equalsIgnoreCase("D")) {
					String tipoDebito = linha.substring(256, 257);
					String numOrdemDebito = linha.substring(257, 268);
					String valorDebitoTotal = linha.substring(268, 283);
					String valorPendente = linha.substring(283, 298);
					String bandeiraRVorigem = linha.substring(298, 299);
					String bandeiraRVajustado = linha.substring(299);
					
					
					a.setTipoDebito(tipoDebito);
					a.setNumOrdemDebito(numOrdemDebito);
					a.setValorDebitoTotal(valorDebitoTotal);
					a.setValorPendente(valorPendente);
					a.setBandeiraRVorigem(bandeiraRVorigem);
					a.setBandeiraRVajustado(bandeiraRVajustado);
				}
				
				a.setTipoRegistro(tipo);
				a.setNumPVajustado(numPVajustado);
				a.setNumRVajustado(numRVajustado);
				a.setDataAjuste(dataAjuste);
				a.setValorAjuste(valorAjuste);
				a.setCaracDebito(caracDebito);
				a.setCodMotivoAjuste(codMotivoAjuste);
				a.setMotivoAjuste(motivoAjuste);
				a.setNumCartao(numCartao);
				a.setDataTransacaoCV(dataTransacaoCV);
				a.setNumRVoriginal(numRVoriginal);
				a.setNumReferenciaCartaFax(numReferenciaCartaFax);
				a.setDataCarta(dataCarta);
				a.setMesReferencia(mesReferencia);
				a.setNumPVoriginal(numPVoriginal);
				a.setDataRVoriginal(dataRVoriginal);
				a.setValorTransacao(valorTransacao);
				a.setCaracDouNet(caracDouNet);
				a.setDataCredito(dataCredito);
				a.setNovoValorParcela(novoValorParcela);
				a.setValorOriginalParcela(valorOriginalParcela);
				a.setValorBrutoResumoVendaOriginal(valorBrutoResumoVendaOriginal);
				a.setValorCancelamentoSolicitado(valorCancelamentoSolicitado);
				a.setNumNSU(numNSU);
				a.setNumAutorizacao(numAutorizacao);
				
				
				System.out.println(a.toString());
			}
			
			if(tipo.equals("036")) {
				
				String numPV = linha.substring(3, 12);
				String numDocumento = linha.substring(12, 23);
				String dataLancamento = this.retornaData(linha.substring(23, 31));
				String valorLancamento = linha.substring(31, 46);
				String caracCredito = linha.substring(46, 47);
				String banco = linha.substring(47, 50);
				String agencia = linha.substring(50, 56);
				String contaCorrente = linha.substring(56, 67);
				String numRVcorrespondente = linha.substring(67, 76);
				String dataRVcorrespondente = this.retornaData(linha.substring(76, 84));
				String valorCreditoOriginal = linha.substring(84, 99);
				String dataVencimentoOriginal = this.retornaData(linha.substring(99, 107));
				String numParcelasTotal  = linha.substring(107, 112);
				String valorBruto = linha.substring(112, 127);
				String valorTaxaDesconto = linha.substring(127, 142);
				String numPVoriginal = linha.substring(142, 151);
				String bandeira= linha.substring(151, 152);
				
				//************** instanciando obj antecipacoes RAV
				AntecipacoesRAV ant = new AntecipacoesRAV();
				ant.setTipoRegistro(tipo);
				ant.setNumPV(numPV);
				ant.setNumDocumento(numDocumento);
				ant.setDataLancamento(dataLancamento);
				ant.setValorLancamento(valorLancamento);
				ant.setCaracCredito(caracCredito);
				ant.setBanco(banco);
				ant.setAgencia(agencia);
				ant.setContaCorrente(contaCorrente);
				ant.setNumRVcorrespondente(numRVcorrespondente);
				ant.setDataRVcorrespondente(dataRVcorrespondente);
				ant.setValorCreditoOriginal(valorCreditoOriginal);
				ant.setDataVencimentoOriginal(dataVencimentoOriginal);
				ant.setNumParcelasTotal(numParcelasTotal);
				ant.setValorBruto(valorBruto);
				ant.setValorTaxaDesconto(valorTaxaDesconto);
				ant.setNumPVoriginal(numPVoriginal);
				ant.setBandeira(bandeira);
				
				
				System.out.println(ant.toString());
			}
			
			
			if(tipo.equals("037")) {
				System.out.println("Totalizador de Créditos");
				
				String numPV = linha.substring(3, 12);
				String brancos = linha.substring(12, 19);
				String dataCredito = this.retornaData(linha.substring(19, 27));
				String valorTotalCreditos = linha.substring(27, 42);
				String brancos2 = linha.substring(42, 43);
				String numBanco = linha.substring(43, 46);
				String numAgencia = linha.substring(46, 52);
				String numContaCorrente = linha.substring(52, 63);
				String dataGeracaoArquivo = this.retornaData(linha.substring(63, 71));
				String dataCreditoAntecipado = this.retornaData(linha.substring(71, 79));
				String valorTotalCreditosAntecipados = linha.substring(79, 94);
				
				//************** instanciando obj Totalizador de Créditos
				TotalizadorCreditos t = new TotalizadorCreditos();
				
				t.setTipoRegistro(tipo);
				t.setNumPV(numPV);
				t.setBrancos(brancos);
				t.setDataCredito(dataCredito);
				t.setValorTotalCreditos(valorTotalCreditos);
				t.setBrancos2(brancos2);
				t.setNumBanco(numBanco);
				t.setNumAgencia(numAgencia);
				t.setNumContaCorrente(numContaCorrente);
				t.setDataGeracaoArquivo(dataGeracaoArquivo);
				t.setDataCreditoAntecipado(dataCreditoAntecipado);
				t.setValorTotalCreditosAntecipados(valorTotalCreditosAntecipados);
				
				System.out.println(t.toString());
				
			}
			
			if(tipo.equals("038")) {
				System.out.println("Ajudes a Débito (via Banco)");
				
				String numPV = linha.substring(3, 12);
				String numDocumento = linha.substring(12, 23);
				String dataEmissao = this.retornaData(linha.substring(23, 31));
				String valorDebito = linha.substring(31, 46);
				String caracDebito = linha.substring(46, 47);
				String banco = linha.substring(47, 50);
				String agencia = linha.substring(50, 56);
				String contaCorrente = linha.substring(56, 67);
				String numRVoriginal = linha.substring(67, 76);
				String dataRVoriginal = this.retornaData(linha.substring(76, 84));
				String valorCreditoOriginal = linha.substring(84, 99);
				String codMotivoDebito = linha.substring(99, 101);
				String motivoDebito = linha.substring(101, 129);
				String numCartao = linha.substring(129, 145);
				String numRefCartaOuFax = linha.substring(145, 160);
				String mesReferencia = linha.substring(160, 166);
				String dataCarta = this.retornaData(linha.substring(166, 174));
				String valorCancelamentoSolicitado = linha.substring(174, 189);
				String numProcesso = linha.substring(189, 204);
				String numPVoriginal = linha.substring(204, 213);
				String dataTransacaoCV = this.retornaData(linha.substring(213, 221));
				String numNSU = linha.substring(221, 233);
				String numResumoDebito = linha.substring(233, 242);
				String dataDebito = this.retornaData(linha.substring(242, 250));
				String valorTransacaoOriginal = linha.substring(250, 265);
				String numAutorizacao = linha.substring(265, 271);
				String tipoDebito = linha.substring(271, 272);
				String valorDebitoTotal = linha.substring(272, 287);
				String valorPendente = linha.substring(287, 302);
				String bandeiraRVorigem = linha.substring(302);
				
				//************** instanciando obj ajustar o debito (via banco)
				AjustesDebitoViaBanco ad = new AjustesDebitoViaBanco();
				
				ad.setTipoRegistro(tipo);
				ad.setNumPV(numPV);
				ad.setNumDocumento(numDocumento);
				ad.setDataEmissao(dataEmissao);
				ad.setValorDebito(valorDebito);
				ad.setCaracDebito(caracDebito);
				ad.setBanco(banco);
				ad.setAgencia(agencia);
				ad.setContaCorrente(contaCorrente);
				ad.setNumRVoriginal(numRVoriginal);
				ad.setDataRVoriginal(dataRVoriginal);
				ad.setValorCreditoOriginal(valorCreditoOriginal);
				ad.setCodMotivoDebito(codMotivoDebito);
				ad.setMotivoDebito(motivoDebito);
				ad.setNumCartao(numCartao);
				ad.setNumRefCartaOuFax(numRefCartaOuFax);
				ad.setMesReferencia(mesReferencia);
				ad.setDataCarta(dataCarta);
				ad.setValorCancelamentoSolicitado(valorCancelamentoSolicitado);
				ad.setNumProcesso(numProcesso);
				ad.setNumPVoriginal(numPVoriginal);
				ad.setDataTransacaoCV(dataTransacaoCV);
				ad.setNumNSU(numNSU);
				ad.setNumResumoDebito(numResumoDebito);
				ad.setDataDebito(dataDebito);
				ad.setValorTransacaoOriginal(valorTransacaoOriginal);
				ad.setNumAutorizacao(numAutorizacao);
				ad.setTipoDebito(tipoDebito);
				ad.setValorDebitoTotal(valorDebitoTotal);
				ad.setValorPendente(valorPendente);
				ad.setBandeiraRVorigem(bandeiraRVorigem);
				
				System.out.println(ad.toString());
			}
			
			
			if(tipo.equals("040")) {
				System.out.println("Serasa");
				
				String numPV = linha.substring(3, 12);
				String qtdConsultasRealizadas = linha.substring(12, 17);
				String valorTotalConsultasPeriodo = linha.substring(17, 32);
				String dataInicioPeriodoConsulta = this.retornaData(linha.substring(32, 40));
				String dataFimPeriodoConsulta = this.retornaData(linha.substring(40, 48));
				String valorPorConsulta = linha.substring(48, 63);
				
				//************** instanciando obj Serasa
				Serasa se = new Serasa();
				
				se.setTipoRegistro(tipo);
				se.setNumPV(numPV);
				se.setQtdConsultasRealizadas(qtdConsultasRealizadas);
				se.setValorTotalConsultasPeriodo(valorTotalConsultasPeriodo);
				se.setDataInicioPeriodoConsulta(dataInicioPeriodoConsulta);
				se.setDataFimPeriodoConsulta(dataFimPeriodoConsulta);
				se.setValorPorConsulta(valorPorConsulta);
				
				System.out.println(se.toString());
			}
			
			if(tipo.equals("041")) {
				System.out.println("AVS");
				
				String numPV = linha.substring(3, 12);
				String qtdConsultasRealizadas = linha.substring(12, 17);
				String valorTotalConsultasPeriodo = linha.substring(17, 32);
				String dataInicioPeriodoConsulta = this.retornaData(linha.substring(32, 40));
				String dataFimPeriodoConsulta = this.retornaData(linha.substring(40, 48));
				String valorPorConsulta = linha.substring(48, 63);
				
				//************** instanciando obj AVS
				AVS avs = new AVS();
				
				avs.setTipoRegistro(tipo);
				avs.setNumPV(numPV);
				avs.setQtdConsultasRealizadas(qtdConsultasRealizadas);
				avs.setValorTotalConsultasPeriodo(valorTotalConsultasPeriodo);
				avs.setDataInicioPeriodoConsulta(dataInicioPeriodoConsulta);
				avs.setDataFimPeriodoConsulta(dataFimPeriodoConsulta);
				avs.setValorPorConsulta(valorPorConsulta);
				
				System.out.println(avs.toString());
			}
			
			if(tipo.equals("042")) {
				System.out.println("Securecode");
				
				String numPV = linha.substring(3, 12);
				String qtdConsultasRealizadas = linha.substring(12, 17);
				String valorTotalConsultasPeriodo = linha.substring(17, 32);
				String dataInicioPeriodoConsulta = this.retornaData(linha.substring(32, 40));
				String dataFimPeriodoConsulta = this.retornaData(linha.substring(40, 49));
				String valorPorConsulta = linha.substring(49);
				
				//************** instanciando obj Securecode
				Securecode sc = new Securecode();
				
				sc.setTipoRegistro(tipo);
				sc.setNumPV(numPV);
				sc.setQtdConsultasRealizadas(qtdConsultasRealizadas);
				sc.setValorTotalConsultasPeriodo(valorTotalConsultasPeriodo);
				sc.setDataInicioPeriodoConsulta(dataInicioPeriodoConsulta);
				sc.setDataFimPeriodoConsulta(dataFimPeriodoConsulta);
				sc.setValorPorConsulta(valorPorConsulta);
				
				System.out.println(sc.toString());
			}
			if(tipo.equals("043")) {
				System.out.println("Ajuste de Crédito");
				
				String numPV = linha.substring(3, 12);
				String resumoCredito = linha.substring(12, 21);
				String numDocumento = linha.substring(21, 32);
				String dataEmissao = retornaData(linha.substring(32, 40));
				String dataCredito = retornaData(linha.substring(40, 48));
				String valorCredito = linha.substring(48, 63);
				String credito = linha.substring(63, 64);
				String banco = linha.substring(64, 67);
				String agencia = linha.substring(67, 73);
				String contaCorrente = linha.substring(73, 84);
				String numMotivoCredito = linha.substring(73, 84);
				String desMotivoCredito = linha.substring(86, 114);
				String bandAjusteCrédito = linha.substring(114, 115);
				
				//************** instanciando obj AjusteCredito *******************
				AjusteCredito ajusteCredito = new AjusteCredito();
				ajusteCredito.setTipoRegistro(tipo);
				ajusteCredito.setPvCreditado(numPV);
				ajusteCredito.setResumoCredido(resumoCredito);
				ajusteCredito.setDocumento(numDocumento);
				ajusteCredito.setDtEmissao(dataEmissao);
				ajusteCredito.setDtCredito(dataCredito);
				ajusteCredito.setValorCredito(valorCredito);
				ajusteCredito.setCredito(credito);
				ajusteCredito.setBanco(banco);
				ajusteCredito.setAgencia(agencia);
				ajusteCredito.setContaCorrente(contaCorrente);
				ajusteCredito.setCodigoMotivoCredito(numMotivoCredito);
				ajusteCredito.setMtCredito(desMotivoCredito);
				ajusteCredito.setBandeira(bandAjusteCrédito);

				System.out.println(ajusteCredito.toString());
			}
			if(tipo.equals("044")) {
				System.out.println("Débitos Pendentes");
				
				String pvAjustado = linha.substring(0, 3);
				String ordemDebito = linha.substring(3, 12);
				String dataOrdemDebito = retornaData(linha.substring(23, 31));
				String valorOrdemDebito = linha.substring(31, 46);
				String codMotivoAjuste = linha.substring(46, 48);
				String motivoAjuste = linha.substring(48, 76);
				String numeroCartao = linha.substring(76, 92);
				String nunNSU = linha.substring(92, 104);
				String dataCV = linha.substring(142, 150);
				String numAutorizacao = linha.substring(112, 118);
				String valorTransacao = linha.substring(118, 133);
				String numeroRVOriginal = linha.substring(133, 142);
				String dataRVOriginal = retornaData(linha.substring(142, 150));
				String numPvOriginal = linha.substring(150, 159);
				String numRefCarta = linha.substring(159, 174);
				String dataCarta = retornaData(linha.substring(174, 182));
				String numeroProcesso = linha.substring(182, 197);
				String mesReferencia = linha.substring(197, 203);
				String valorCompensado = linha.substring(203, 218);
				String dataPagamento = linha.substring(218, 226);
				String valorPendente = linha.substring(226, 241);
				String processoRetencao = linha.substring(241, 256);
				String codMeioCompensacao = linha.substring(256, 258);
				String meioCompensacao = linha.substring(258, 286);
				
				//************** instanciando obj Debitos Pendentes *******************
				
				DebitosPendentes debitosPendentes = new DebitosPendentes();
				debitosPendentes.setTpRgistro(tipo);
				debitosPendentes.setPvAjustado(pvAjustado);
				debitosPendentes.setOrdemDebito(ordemDebito);
				debitosPendentes.setDataOrdemDebito(dataOrdemDebito);
				debitosPendentes.setValorAjuste(valorOrdemDebito);
				debitosPendentes.setIdMotivoAjuste(codMotivoAjuste);
				debitosPendentes.setMotivoAjuste(motivoAjuste);
				debitosPendentes.setNumCartao(numeroCartao);
				debitosPendentes.setNsu(nunNSU);
				debitosPendentes.setDataCvNsu(dataCV);
				debitosPendentes.setNumeroAutorizacao(numAutorizacao);
				debitosPendentes.setValorTransacaoOriginal(valorTransacao);
				debitosPendentes.setNumeroRVOriginal(numeroRVOriginal);
				debitosPendentes.setDataRVOriginal(dataRVOriginal);
				debitosPendentes.setNumeroPVOriginal(numPvOriginal);
				debitosPendentes.setDataRVOriginal(dataCarta);
				debitosPendentes.setNumeroProcesso(numeroProcesso);
				debitosPendentes.setMesReferencia(mesReferencia);
				debitosPendentes.setValorPago(valorCompensado);
				debitosPendentes.setDataCompensacao(dataPagamento);
				debitosPendentes.setValorPendente(valorPendente);
				debitosPendentes.setProcessoRetencao(processoRetencao);
				debitosPendentes.setMeioCompensado(codMeioCompensacao);
				debitosPendentes.setDescricaoMeioCompensado(meioCompensacao);
			

				
				System.out.println(debitosPendentes.toString());
				
				}
			
			if(tipo.equals("045")) {
				System.out.println("Débitos Liquidados");
				
				 String numeroPV = linha.substring(3, 12);
				 String numeroOrdemDebito = linha.substring(12, 23);
				 String dataOrdemDebito = retornaData(linha.substring(23, 31));
				 String valorTotalDebito = linha.substring(31, 46);
				 String identificadorMotivoAjuste = linha.substring(46, 48);
				 String descricaoMotivoAjuste = linha.substring(49, 76);
				 String numeroCartao = linha.substring(76, 92);
				 String numeroUSU = linha.substring(92, 104);
				 String dataCVNSU = retornaData(linha.substring(104, 112));
				 String numAutorizacao = linha.substring(112, 118);
				 String valorTransacaoOriginal = linha.substring(118, 133);
				 String numRVOriginal = linha.substring(133, 142);
				 String dataRVOriginal = retornaData(linha.substring(142, 150));
				 String numPVOriginal = linha.substring(150, 159);
				 String nCartaReferencia = linha.substring(159, 174);
				 String dataCancelamento = retornaData(linha.substring(174, 182));
				 String numeroProcesso = linha.substring(182, 197);
				 String mesReferencia = linha.substring(197, 203);
				 String valorPago = linha.substring(203, 218);
				 String dataLiquidacao = retornaData(linha.substring(218, 226));
				 String processoRet = linha.substring(226, 241);
				 String identficadorCompensado = linha.substring(241, 243);
				 String descricaoCompensado = linha.substring(243, 271);
				
				//************** instanciando obj Debitos Liquidados *******************
				
				DebitosLiquidados debitosLiquidados = new DebitosLiquidados();
				debitosLiquidados.setTipoRegistro(tipo);
				debitosLiquidados.setNumPVOriginal(numPVOriginal);
				debitosLiquidados.setNumeroOrdemDebito(numeroOrdemDebito);
				debitosLiquidados.setDataOrdemDebito(dataOrdemDebito);
				debitosLiquidados.setValorTotalDebito(valorTotalDebito);
				debitosLiquidados.setIdentificadorMotivoAjuste(identificadorMotivoAjuste);
				debitosLiquidados.setDescricaoMotivoAjuste(descricaoMotivoAjuste);
				debitosLiquidados.setNumeroCartao(numeroCartao);
				debitosLiquidados.setNumeroUSU(numeroUSU);
				debitosLiquidados.setDataCVNSU(dataCVNSU);
				debitosLiquidados.setNumAutorizacao(numAutorizacao);
				debitosLiquidados.setValorTransacaoOriginal(valorTransacaoOriginal);
				debitosLiquidados.setNumRVOriginal(numRVOriginal);
				debitosLiquidados.setDataRVOriginal(dataRVOriginal);
				debitosLiquidados.setNumPVOriginal(numPVOriginal);
				debitosLiquidados.setnCartaReferencia(nCartaReferencia);
				debitosLiquidados.setDataCancelamento(dataCancelamento);
				debitosLiquidados.setNumeroProcesso(numeroProcesso);
				debitosLiquidados.setMesReferencia(mesReferencia);
				debitosLiquidados.setValorPago(valorPago);
				debitosLiquidados.setDataLiquidacao(dataLiquidacao);
				debitosLiquidados.setProcessoRet(processoRet);
				debitosLiquidados.setIdentficadorCompensado(identficadorCompensado);
				debitosLiquidados.setDescricaoCompensado(descricaoCompensado);

				
				System.out.println(debitosLiquidados.toString());
				
				}
			
			if(tipo.equals("049")) {
				System.out.println("Desagendamento de Parcelas");
				
				 String originalPV = linha.substring(03, 12);
				 String originalRV = linha.substring(12, 21);
				 String numDocumento = linha.substring(21, 36);
				 String dataCredito = retornaData(linha.substring(36, 44));
				 String novoValorParcela = linha.substring(44, 59);
				 String valorOriginalParcela = linha.substring(59, 74);
				 String valorAjuste = linha.substring(74 , 89);
				 String dataCancelamento = retornaData(linha.substring(89, 97));
				 String valorRVOriginal = linha.substring(97, 112);
				 String valorCancelamentoSolicitado = linha.substring( 112, 127);
				 String numeroCartao = linha.substring(127, 143);
				 String dataTransacao = retornaData(linha.substring( 143, 151));
				 String nsu = linha.substring(151, 163);
				 String tipoDebito = linha.substring(163, 164);
				 String numeroParcela = linha.substring(164, 166);
				 String bandeiraRVOrigem = linha.substring(166, 167);
				
				//************** instanciando obj Desagendamento de Parcelas *******************
				
				DesagendamentoParcelas desagendamentoParcelas = new DesagendamentoParcelas();
				
				desagendamentoParcelas.setTipoRegistro(tipo);
				desagendamentoParcelas.setOriginalPV(originalPV);
				desagendamentoParcelas.setOriginalRV(originalRV);
				desagendamentoParcelas.setNumDocumento(numDocumento);
				desagendamentoParcelas.setDataCredito(dataCredito);
				desagendamentoParcelas.setNovoValorParcela(novoValorParcela);
				desagendamentoParcelas.setValorOriginalParcela(valorOriginalParcela);
				desagendamentoParcelas.setValorAjuste(valorAjuste);
				desagendamentoParcelas.setDataCancelamento(dataCancelamento);
				desagendamentoParcelas.setValorRVOriginal(valorRVOriginal);
				desagendamentoParcelas.setValorCancelamentoSolicitado(valorCancelamentoSolicitado);
				desagendamentoParcelas.setNumeroCartao(numeroCartao);
				desagendamentoParcelas.setDataTransacao(dataTransacao);
				desagendamentoParcelas.setNsu(nsu);
				desagendamentoParcelas.setTipoDebito(tipoDebito);
				desagendamentoParcelas.setNumeroParcela(numeroParcela);
				desagendamentoParcelas.setBandeiraRVOrigem(bandeiraRVOrigem);
				
				System.out.println(desagendamentoParcelas.toString());
				
				}
			
			if(tipo.equals("050")) {
				System.out.println("Totalizador Matriz");
				
				String numeroMatriz = linha.substring(3, 12);
				String quantidadeResumosMatriz = linha.substring(12, 18);
				String valorTotalCreditosNormais = linha.substring(18, 33);
				String quantidadeCreditosAntecipados = linha.substring(	33, 39);
				String valorTotalAntecipados = linha.substring(39, 54);
				String quantidadeAjusteCredito = linha.substring(54, 58);
				String valorTotalAjusteCredito = linha.substring( 58, 73);
				String quantidadeAjusteDebito = linha.substring(73, 79);
				String valorTotalAjusteDebito = linha.substring(79, 94);
				
				//************** instanciando obj Totalizador da Matriz *******************
				
				TotalizadorMatriz totalizadorMatriz = new TotalizadorMatriz();
				
				totalizadorMatriz.setTpRegistro(tipo);;
				totalizadorMatriz.setNumeroMatriz(numeroMatriz);
				totalizadorMatriz.setQuantidadeResumosMatriz(quantidadeResumosMatriz);
				totalizadorMatriz.setValorTotalCreditosNormais(valorTotalCreditosNormais);
				totalizadorMatriz.setQuantidadeCreditosAntecipados(quantidadeCreditosAntecipados);
				totalizadorMatriz.setValorTotalAntecipados(valorTotalAntecipados);
				totalizadorMatriz.setQuantidadeAjusteCredito(quantidadeAjusteCredito);
				totalizadorMatriz.setValorTotalAjusteCredito(valorTotalAjusteCredito);
				totalizadorMatriz.setQuantidadeAjusteDebito(quantidadeAjusteDebito);
				totalizadorMatriz.setValorTotalAjusteDebito(valorTotalAjusteDebito);
		
				System.out.println(totalizadorMatriz.toString());
				
				}
			
			
		}
		fr.close();
		bf.close();
	}
	
	public String retornaData(String data) {
		String dia = data.substring(0, 2);
		String mes = data.substring(2, 4);
		String ano = data.substring(4, 8);
		String mdata = dia + "/" + mes + "/" + ano;
		return mdata;
		
	}
	
	public String retornaTipoTransacao(String tipoTransacao) {
		switch(tipoTransacao) {
		case "1":
			tipoTransacao = "à vista";
			break;
		case "2":
			tipoTransacao = "parcelado sem juros";
			break;
		case "3":
			tipoTransacao = "parcelado IATA";
			break;
		case "4":
			tipoTransacao = "rotativo dólar";
			break;
		case "5":
			tipoTransacao = "CDC";
			break;
		case "6":
			tipoTransacao = "Pré-datada";
			break;
		case "7":
			tipoTransacao = "Trishop";
			break;
		case "8":
			tipoTransacao = "Construcard";
			break;
		}
		
		return tipoTransacao;
	}
	
	public String retornaStatusCredito(String status) {
		switch(status) {
		case "00":
			status = "CV OK";
			break;
		case "01":
			status = "A emitir";
			break;
		case "02":
			status = "Trânsito";
			break;
		case "03":
			status = "Pendente Banco";
			break;
		case "04":
			status = "Pendente Matriz";
			break;
		case "05":
			status = "Pendente Filial";
			break;
		case "06":
			status = "Baixada";
			break;
		case "07":
			status = "Trânsito Fita";
			break;
		case "08":
			status = "Baixa Automática";
			break;
		case "09":
			status = "Baixado para Penhora ou Retenção";
			break;
		case "11":
			status = "Suspenso";
			break;
		case "12":
			status = "Penhorado";
			break;
		case "13":
			status = "Retido";
			break;
		}
		
		return status;
	}
	
	public String retornaAjuste(int ajuste) {
		String status = "";
		switch(ajuste) {
		case 1:
			status = "FRANQ. INTERLIGAÇÃO";
			break;
		case 2:
			status = "CONSULTA DE CHEQUES";
			break;
		case 3:
			status = "DÉBITOS PARCELADOS";
			break;
		case 4:
			status = "DÉBITO TX TRIBUTO";
			break;
		case 5:
			status = "TX MAN DO TEF";
			break;
		case 6:
			status = "POS-INATIV/CONEC/PIN";
			break;
		case 7:
			status = "CREDENC/ADESAO";
			break;
		case 8:
			status = "REPOS/ADIC MAQUINETA";
			break;
		case 9:
			status = "CANCEL/CHBK MAESTRO";
			break;
		case 10:
			status = "ADESÃO SECURECODE";
			break;
		case 11:
			status = "MENS.SECURECODE";
			break;
		case 13:
			status = "CONS.SECURECODE";
			break;
		case 14:
			status = "TARIFA DÉBITO";
			break;
		case 15:
			status = "CBK CARTÃO CHIP";
			break;
		case 16:
			status = "ESTORNO CR.INDEV.CI";
			break;
		case 17:
			status = "INDENIZA PÓS PERDIDO";
			break;
		case 18:
			status = "CANCEL DE VENDAS";
			break;
		case 19:
			status = "SEGUNDA VIA EXTRATO";
			break;
		case 20:
			status = "POS-INATIV/CONEC/PIN";
			break;
		case 21:
			status = "CANCELAMENTO MAESTRO";
			break;
		case 22:
			status = "CONTESTAÇAO DE VENDA";
			break;
		case 23:
			status = "CONTESTAÇAO DE VENDA";
			break;
		case 24:
			status = "TRF AD EXCESSO CBACK";
			break;
		case 28:
			status = "AL.POS/PINPAD/TX CONECT";
			break;
		case 29:
			status = "DÉBITO RECARGA";
			break;
		case 30:
			status = "CANCEL DESP DOLAR";
			break;
		case 34:
			status = "MODELO TARIFARIO";
			break;
		case 35:
			status = "CONSULTA AVS";
			break;
		case 36:
			status = "DEVOLUCAO CV";
			break;
		case 37:
			status = "ESTORNO CR.INDEV.";
			break;
		case 38:
			status = "ESTORNO TX ADMIN";
			break;
		case 39:
			status = "ESTORNO REBATE";
			break;
		case 40:
			status = "TARIFA EXT.MENSAL";
			break;
		case 46:
			status = "TAXA PARC. ESPECIAL";
			break;
		case 48:
			status = "AL.POS/PINPAD/TX CONECT";
			break;
		case 49:
			status = "POS-INATIV/CONEC/PIN";
			break;
		case 51:
			status = "CRED SECURECODE";
			break;
		case 52:
			status = "REVERSÃO DEBITO CBK";
			break;
		case 53:
			status = "CREDITO RECARGA";
			break;
		case 54:
			status = "TOT.LIQID.A MENOR";
			break;
		case 55:
			status = "CRED SECURECODE";
			break;
		case 56:
			status = "PREMIO PROMOCAO PARCELADO";
			break;
		case 57:
			status = "PGTO DESAGIO";
			break;
		case 58:
			status = "CREDITO ALUGUEL";
			break;
		case 59:
			status = "REBATE MENSAL";
			break;
		case 60:
			status = "CRED SECURECODE";
			break;
		case 61:
			status = "DEV CRED PGTO MAIOR";
			break;
		case 62:
			status = "REGULARIZAÇÃO DIF. TAXA";
			break;
		case 63:
			status = "REGUL.DB ANTERIOR";
			break;
		case 64:
			status = "PGTO DE RV";
			break;	
		case 65:
			status = "COMPL.CR EFET.MENOR";
			break;	
		case 66:
			status = "PGT.JURO CORRECAO";
			break;	
		case 67:
			status = "PGT.CV ADULTERADO";
			break;	
		case 68:
			status = "PGT.CV U$$-P.TUR";
			break;	
		case 69:
			status = "PGTO VIACAO AEREA";
			break;	
		case 70:
			status = "PGT.P/TRANSF.TIT.";
			break;	
		case 71:
			status = "PGT.N.S/J-1A PARC";
			break;	
		case 72:
			status = "PGT.N.S/J-2A PARC";
			break;	
		case 73:
			status = "PGT.N.S/J-3A PARC";
			break;	
		case 74:
			status = "PGT.N.S/J-4A PARC";
			break;	
		case 75:
			status = "PGT.N.S/J-5A PARC";
			break;	
		case 76:
			status = "PGT.N.S/J-6A PARC";
			break;	
		case 77:
			status = "PGT.N.S/J-7A PARC";
			break;	
		case 78:
			status = "PGT.N.S/J-8A PARC";
			break;	
		case 79:
			status = "PGT.N.S/J-9A PARC";
			break;	
		case 80:
			status = "CAPTURA CV OFF-TO";
			break;	
		case 81:
			status = "PCTE TUR.CREDITO";
			break;	
		case 82:
			status = "COMISS.SOBRE VENDA";
			break;	
		case 83:
			status = "IR S/COMISSAO";
			break;	
		case 84:
			status = "ADIC.IR ESTAD";
			break;	
		case 85:
			status = "PGTO DE RV";
			break;	
		case 86:
			status = "ANTECIPACAO DOLAR";
			break;	
		case 87:
			status = "DEVOL.CANCEL.DOLAR";
			break;	
		case 88:
			status = "TIER PRICING";
			break;
		case 89:
			status = "EST CONS.SERASA/AVS";
			break;
		case 90:
			status = "ESTOR.TARIFA ENV.DOC";
			break;
		case 91:
			status = "ESTORNO POS PERDIDO";
			break;
		case 92:
			status = "ESTOR.TARIFA ENV.DOC";
			break;
		case 93:
			status = "EST.EXT SALDOS ABER";
			break;
		case 94:
			status = "ESTOR.TAXA DE ADESÃO";
			break;
		case 95:
			status = "EST AL.POS/TX.CONET";
			break;
		case 96:
			status = "ESTOR.TAR 2°VIA EXT";
			break;
		case 99:
			status = "DEBITO NÃO ACATADO";
			break;
			
		}
		
		return status;
	}
	
}
