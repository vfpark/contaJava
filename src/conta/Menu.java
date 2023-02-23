package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
	
	public static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opcao, numero, agencia = 0, tipo, aniversario, numeroDestino;
		float saldo, limite, valor;
		String titular;

		Scanner leia = new Scanner(System.in);

		 // Teste da Classe Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(2, 123, 1, "Mariana", 15000.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		
        // Teste da Classe Conta Poupança
		ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Victor", 100000.0f, 15);
		cp1.visualizar();
        cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();
		
		while (true) {
			
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
			
			try {
				opcao = leia.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao=0;
			}
			
			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");
					
					System.out.println("Número da Agência: ");
					agencia = leia.nextInt();
					
					System.out.println("Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					do{
						System.out.println("Tipo da Conta (1-CC / 2 -CP): ");
						tipo = leia.nextInt();
					}while (tipo < 1 && tipo > 2);
					
					System.out.println("Saldo da Conta: ");
					saldo = leia.nextFloat();
					
					switch(tipo) {
					case 1 ->{
						System.out.println("Limite da Conta Corrente: ");
						limite = leia.nextFloat();	
						ContaCorrente cc = new ContaCorrente (0, agencia, tipo, titular, saldo, limite);
						cc.visualizar();
					}
					case 2 ->{
						System.out.println("Aniversário da Conta Poupança: ");
						aniversario = leia.nextInt();
						ContaPoupanca cp = new ContaPoupanca (0, agencia, tipo, titular, saldo, aniversario);
						cp.visualizar();
					}
					}
					
					keyPress();	
					break;
					
				case 2:
					System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
					keyPress();
					break;
					
				case 3:
					System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
					
					System.out.println("Número da Conta: ");
					numero = leia.nextInt();
					keyPress();
					break;
					
				case 4:
					System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
					
					System.out.println("Número da Conta: ");
					numero = leia.nextInt();
					
					System.out.println("Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					tipo = 0;
					
					System.out.println("Saldo da Conta: ");
					saldo = leia.nextFloat();
					
					switch(tipo) {
					case 1 ->{
						System.out.println("Limite da Conta Corrente: ");
						limite = leia.nextFloat();	
						ContaCorrente cc = new ContaCorrente (0, agencia, tipo, titular, saldo, limite);
						cc.visualizar();
					}
					case 2 ->{
						System.out.println("Aniversário da Conta Poupança: ");
						aniversario = leia.nextInt();
						ContaPoupanca cp = new ContaPoupanca (0, agencia, tipo, titular, saldo, aniversario);
						cp.visualizar();
					}
					}
					
					keyPress();
					break;
					
				case 5:
					System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
					
					System.out.println("Número da Conta: ");
					numero = leia.nextInt();
					
					keyPress();
					break;
					
				case 6:
					System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
					
					System.out.println("Número da Conta: ");
					numero = leia.nextInt();
					
					System.out.println("Valor do Saque: ");
					valor = leia.nextFloat();
					
					keyPress();
					break;
					
				case 7:
					System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");
					
					System.out.println("Número da Conta: ");
					numero = leia.nextInt();
					
					System.out.println("Valor do Depósito: ");
					valor = leia.nextFloat();
					
					keyPress();
					break;
					
				case 8:
					System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");
					
					System.out.println("Número da Conta - Origem: ");
					numero = leia.nextInt();
					
					System.out.println("Número da Conta - Destino: ");
					numeroDestino = leia.nextInt();
					
					System.out.println("Valor da Tranferência: ");
					valor = leia.nextFloat();
					
					keyPress();
					break;
					
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
					keyPress();
					break;
			}
		}
	}
		
		public static void keyPress() {

			try {

				System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
				System.in.read();

			} catch (IOException e) {

				System.out.println("Você pressionou uma tecla diferente de enter!");

			}
		}

	}
