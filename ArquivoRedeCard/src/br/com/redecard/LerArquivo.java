package br.com.redecard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import br.com.redecard.classes.AjusteNETdesagendamentos;
import br.com.redecard.classes.AntecipacoesRAV;
import br.com.redecard.classes.Creditos;
import br.com.redecard.classes.HeaderArquivo;
import br.com.redecard.classes.HeaderMatriz;
import br.com.redecard.classes.TotalizadorCreditos;
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
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
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
	
	
}
