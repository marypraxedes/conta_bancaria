package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {
	
	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();

	public static void main(String[] args) {
			
		
			int opcao;
			
			// Criar dados de teste
			criarContasTeste();
			
			do {
				
				System.out.println(Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND);
				System.out.println("*****************************************************");
				System.out.println("                                                     ");
				System.out.println("                     APPLE BANK                      ");
				System.out.println("                                                     ");
				System.out.println("*****************************************************");
				System.out.println("            1 - Criar Conta                          ");
				System.out.println("            2 - Listar Todas as Contas               ");
				System.out.println("            3 - Buscar Conta por Número              ");
				System.out.println("            4 - Atualizar Dados da Conta             ");
				System.out.println("            5 - Apagar Conta                         ");
				System.out.println("            6 - Sacar                                ");
				System.out.println("            7 - Depositar                            ");
				System.out.println("            8 - Transferir Valores entre Contas      ");
				System.out.println("            9 - Sobre o Projeto                      ");
				System.out.println("            0 - Sair                                 ");
				System.out.println("                                                     ");
				System.out.println("*****************************************************" + Cores.TEXT_RESET);
				System.out.println("Digite a opção desejada: ");
				
				try {
					opcao = leia.nextInt();
					leia.nextLine();
				}catch(InputMismatchException e) {
					opcao = -1;
					System.out.println("Digite um número inteiro entre 0 e 9");
					leia.nextLine();
				}
				switch(opcao) {
				case 1:
					System.out.println("Criar conta: \n");
					cadastrarConta();
					keyPress();
				break;
					
				case 2:
					System.out.println("Listar todas as contas: \n");
					listarContas();
					keyPress();
				break;
				
				case 3: 
					System.out.println("Buscar conta por número: \n");
					keyPress();
				break;
				
				case 4:
					System.out.println("Atualizar dados da conta: \n");
					keyPress();
				break;
				
				case 5:
					System.out.println("Apagar conta: \n");
					keyPress();
				break;
				
				case 6:
					System.out.println("Sacar: \n");
					keyPress();
				break;
				
				case 7:
					System.out.println("Depositar: \n");
					keyPress();
				break;
				
				case 8:
					System.out.println("Transferir valores entre contas: \n");
					keyPress();
				break;
				
				case 9:
					sobre();
					keyPress();
					
				break;
				
				case 0:
					System.out.println("\nObrigado por utilizar os serviços financeiros da APPLE BANK!");
					
				break;
				
				default:
				System.out.println("\nOpção Inválida! Escolha um número de 0 a 9.");
				
				keyPress();
				break;
				
				}
				
			}while (opcao != 0);
			
		
			leia.close();
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Maryane Praxedes ");
		System.out.println("Contato - mary.praxedes@icloud.com");
		System.out.println("github.com/marypraxedes");
		System.out.println("*********************************************************");
	}
	
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	}
	
	public static void criarContasTeste() {
		contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10));
	}
	
	public static void listarContas() {
		contaController.listarTodas();
	}
	
	public static void cadastrarConta() {
		
		System.out.println("Digite o número da agência: ");
		int agencia = leia.nextInt();
		
		System.out.println("Digite o nome do titular da conta: ");
		leia.skip("\\R");
		String titular = leia.nextLine();
		
		System.out.println("Digite o tipo da conta (1 - CC | 2 - CP): ");
		int tipo = leia.nextInt();
		
		System.out.println("Digite o saldo da conta: ");
		float saldo = leia.nextFloat();
		
		switch(tipo) {
		case 1: 
			System.out.println("Digite o limite da conta: ");
			float limite = leia.nextFloat();
			
			contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		break;
		case 2:
			System.out.println("Digite o dia do aniversário da conta: ");
			int aniversario = leia.nextInt();
			
			contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		break;	
		default: System.out.println(Cores.TEXT_RED + "Tipo de conta inválida!" + Cores.TEXT_RESET);
		}
	}
}
