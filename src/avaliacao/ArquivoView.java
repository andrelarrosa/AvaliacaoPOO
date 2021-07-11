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
		exibirMensagem("Bem-vindo ao sistema que l� arquivos txt");
		int continuar = exibirMenu();
		while(continuar != 7) {
			continuar = exibirMenu();
		}
		exibirMensagem("At� logo");
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
		exibirMensagem("Opera��es: ");
		exibirMensagem("1-Somar N�meros do Arquivo");
		exibirMensagem("2-Buscar N�mero");
		exibirMensagem("3-Calcular M�dia");
		exibirMensagem("4-Imprimir todos os N�meros do arquivo");
		exibirMensagem("5-Exibir Maior N�mero");
		exibirMensagem("6-Exibir Menor N�mero");
		exibirMensagem("7-Sair");
		exibirMensagem("Digite o n�mero da op��o desejada: ");
		int operacao = lerEntradaInt();
		executarOperacaoSelecionada(operacao);
		return operacao;
	}
	
	public int exibirMenuConfiguracao(){
		exibirMensagem("Voc� deseja: ");
		exibirMensagem("1-Utilizar n�meros inteiros");
		exibirMensagem("2-Utilizar n�meros quebrados");
		int operacao = lerEntradaInt();
		return operacao;
	}

	
	
	
}
