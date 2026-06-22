package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
			
		
			int opcao;
			
			/* Instanciar Objetos da Classe Conta*/
			
			Conta c1 = new Conta(1, 123, 1, "Darth Vader", 200000.00f);
			c1.visualizar();
			Conta c2 = new Conta(1, 123, 2, "Peter Parker", 100000.00f);
			c2.visualizar();
			
			c1.setSaldo(300000.00f);
			c1.setTitular("Darth Vader");
			c1.visualizar();
			
			System.out.println("\nSacar R$ 1000,00 da conta C2: " + (c2.sacar(1000.00f) ? 
					"Saque efetuado com Sucesso!" : "Saldo insuficiente"));
			
			System.out.println("\nSacar R$ 1000,00 da conta C2: " + (c2.sacar(300000.00f) ? 
					"Saque efetuado com Sucesso!" : "Saldo insuficiente"));
			c2.visualizar();
			
			c2.depositar(50000.00f);
			c2.visualizar();
			
			
			do {
				
				System.out.println(Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND);
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
				System.out.println("*****************************************************");
				System.out.println("Digite a opção desejada: ");
				opcao = leia.nextInt();
				leia.nextLine();
					
				switch(opcao) {
				case 1:
					System.out.println("Criar conta: \n");
				
				break;
					
				case 2:
					System.out.println("Listar todas as contas: \n");
				break;
				
				case 3: 
					System.out.println("Buscar conta por número: \n");
					
				break;
				
				case 4:
					System.out.println("Atualizar dados da conta: \n");
					
				break;
				
				case 5:
					System.out.println("Apagar conta: \n");
					
				break;
				
				case 6:
					System.out.println("Sacar: \n");
					
				break;
				
				case 7:
					System.out.println("Depositar: \n");
					
				break;
				
				case 8:
					System.out.println("Transferir valores entre contas: \n");
					
				break;
				
				case 9:
					sobre();
					
				break;
				
				case 0:
					System.out.println("\nObrigado por utilizar os serviços financeiros da APPLE BANK!");
					
				break;
				
				default:
				System.out.println("\nOpção Inválida!\n");
				break;
				
				}
				
			}while (opcao != 0);
			
		
			leia.close();
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Maryane ");
		System.out.println("Contato - mary.praxedes@icloud.com");
		System.out.println("github.com/marypraxedes");
		System.out.println("*********************************************************");
	}
	
}
