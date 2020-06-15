package br.com.matheus.redecard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import br.com.matheus.redecard.classes.HeaderArquivo;
import br.com.matheus.redecard.classes.HeaderMatriz;
import br.com.matheus.redecard.classes.AjusteNETdesagendamentos;
import br.com.matheus.redecard.classes.Creditos;

public class LerArquivo {
	
	public void leitura() throws IOException{
		File arquivo = new File("C:\\Users\\mathe\\Documents\\Project\\USJ\\ArquivoRedeCard\\NEFI_TESTE_1908.TXT");
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
				String dataAjuste;
				String valorAjude;
				String caracDebito;
				String codMotivoAjude;
				String MotivoAjude;
				String numCartao;
				String dataTransacaoCV;
				String numRVoriginal;
				String numReferenciaCartaFax;
				String dataCarta;
				String mesReferencia;
				String numPVoriginal;
				String dataRVoriginal;
				String valorTransacao;
				String caracDouNet;
				String dataCredito;
				String novoValorParcela;
				String valorOriginalParcela;
				String valorBrutoResumoVendaOriginal;
				String valorCancelamentoSolicitado;
				String numNSU;
				String numAutorizacao;
				String tipoDebito;
				String numOrdemDebito;
				String valorDebitoTotal;
				String valorPendente;
				String bandeiraRVorigem;
				String bandeiraRVajustado;
				//************** instanciando obj ajuste e desagendamentos
				AjusteNETdesagendamentos a = new AjusteNETdesagendamentos();
				a.setTipoRegistro(tipo);
				a.setNumPVajustado(numPVajustado);
				a.setNumRVajustado(numRVajustado);
				
				
				System.out.println(a.toString());
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
