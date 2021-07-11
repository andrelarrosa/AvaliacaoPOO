package avaliacao;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ArquivoView {

	private Scanner entrada;
	private PrintStream saida;
	
	public ArquivoView() {
		this.entrada = new Scanner(System.in);
		this.saida = System.out;
	}
	private void exibirMensagem(String message) {
		this.saida.println(message);
	}
	
	
	private int lerEntradaInt() {
		return this.entrada.nextInt();
	}
	
	private double lerEntradaDouble() {
		return this.entrada.nextDouble();
	}
	
	private String lerEntradaString() {
		return this.entrada.next();
	}
	
	public void inicializar() throws IOException {
		exibirMensagem("Bem-vindo ao sistema que lê arquivos txt");
		int continuar = exibirMenu();
		while(continuar != 7) {
			continuar = exibirMenu();
		}
		exibirMensagem("Até logo");
	}
	
	
	
	public boolean executarOperacaoSelecionada(int operacao) throws IOException {
		Arquivo arquivo = new Arquivo();
		if(operacao == 1) {
			int configuracao = exibirMenuConfiguracao();
			if(configuracao == 1) {
				System.out.println("informe o caminho do arquivo: ");
				String path = lerEntradaString();
				arquivo.somarNumerosArquivo(path);	
			}else {
				System.out.println("informe o caminho do arquivo: ");
				String path = lerEntradaString();
				arquivo.somarNumerosArquivoQuebrado(path);
			}
		} else if(operacao == 2) {
			int configuracao = exibirMenuConfiguracao();
			if(configuracao == 1) {
				System.out.println("informe o caminho do arquivo: ");
				String path = lerEntradaString();
				System.out.println("Informe o valor que deseja encontrar: ");
				int valor = lerEntradaInt();
				System.out.println(arquivo.encontrarValor(path, valor));	
			}else {
				System.out.println("informe o caminho do arquivo: ");
				String path = lerEntradaString();
				System.out.println("Informe o valor que deseja encontrar: ");
				double valor = lerEntradaDouble();
				System.out.println(arquivo.encontrarValorQuebrado(path, valor));
			}
		}else if(operacao == 3) {
			int configuracao = exibirMenuConfiguracao();
			if(configuracao == 1) {
				System.out.println("informe o caminho do arquivo: ");
				String path = lerEntradaString();
				arquivo.calcularMedia(path);	
			}else {
				System.out.println("informe o caminho do arquivo: ");
				String path = lerEntradaString();
				arquivo.calcularMediaQuebrado(path);
			}
		}else if(operacao == 4) {
			int configuracao = exibirMenuConfiguracao();
			System.out.println("informe o caminho do arquivo: ");
			String path = lerEntradaString();
			arquivo.lerArquivo(path);
		}else if(operacao == 5) {
			int configuracao = exibirMenuConfiguracao();
			if(configuracao == 1) {
				System.out.println("informe o caminho do arquivo: ");
				String path = lerEntradaString();
				arquivo.encontrarMaiorNumero(path);	
			}else {
				System.out.println("informe o caminho do arquivo: ");
				String path = lerEntradaString();
				arquivo.encontrarMaiorNumeroQuebrado(path);
			}
			
		}else if(operacao == 6) {
			int configuracao = exibirMenuConfiguracao();
			if(configuracao == 1) {
				System.out.println("informe o caminho do arquivo: ");
				String path = lerEntradaString();
				arquivo.encontrarMenorNumero(path);	
			}else {
				System.out.println("informe o caminho do arquivo: ");
				String path = lerEntradaString();
				arquivo.encontrarMenorNumeroQuebrado(path);	
			}
		}else if(operacao == 7) {
			return false;
		}
		return true;
	}
	public int exibirMenu() throws IOException {
		exibirMensagem("Operações: ");
		exibirMensagem("1-Somar Números do Arquivo");
		exibirMensagem("2-Buscar Número");
		exibirMensagem("3-Calcular Média");
		exibirMensagem("4-Imprimir todos os Números do arquivo");
		exibirMensagem("5-Exibir Maior Número");
		exibirMensagem("6-Exibir Menor Número");
		exibirMensagem("7-Sair");
		exibirMensagem("Digite o número da opção desejada: ");
		int operacao = lerEntradaInt();
		executarOperacaoSelecionada(operacao);
		return operacao;
	}
	
	public int exibirMenuConfiguracao(){
		exibirMensagem("Você deseja: ");
		exibirMensagem("1-Utilizar números inteiros");
		exibirMensagem("2-Utilizar números quebrados");
		int operacao = lerEntradaInt();
		return operacao;
	}

	
	
	
}
