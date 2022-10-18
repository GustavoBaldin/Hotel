package execucao;

import java.util.Scanner;

import entidades.Funcionario;

public class Executar {
	
	static PainelDeControle controle = new PainelDeControle();
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		Funcionario funcionario = controle.loginFuncionario();
		int opcao = 0;
		
		while (opcao != -1) {
			System.out.println("1 - Criar Clientes");
			System.out.println("2 - Criar Reserva");
			System.out.println("3 - Criar Funcionário");
			System.out.println("4 - Criar Quarto");
			System.out.println("5 - Excluir Reserva");
			System.out.println("6 - Listar Quartos Desocupados");
			System.out.println("7 - Listar Clientes");
			System.out.println("8 - Listar Reservas");
			System.out.println("9 - Receita Hospedagens");
			System.out.println("-1 - Sair do sistema");
			System.out.println("-2 - Logar em Outra Conta");
			
			
			opcao = entrada.nextInt();
			
			switch (opcao) {
				case 1:
					controle.registrarCliente(funcionario);
					break;
				case 2:
					controle.criarReserva(funcionario);
					break;
				case 3:
					if (funcionario.getPermissao() < 3) {
						System.out.println("Você não pode usar essa função.");
					}
					else {
						controle.registrarFuncionario();
					}
					break;
				case 4:
					if (funcionario.getPermissao() < 3) {
						System.out.println("Você não pode usar essa função.");
					}
					else {
						controle.registrarQuarto();
					}
					break;
				case 5:
					controle.deletarReserva();
					break;
				case 6:
					controle.consultarQuartosDesocupados();
					break;
				case 7:
					controle.listarClientes();
					break;
				case 8:
					controle.listarReservas();
					break;
				case 9:
					if (funcionario.getPermissao() < 2) {
						System.out.println("Você não pode usar essa função.");
					}
					else {
						controle.receitaHospedagens();
					}
					break;
				case -2:
					funcionario = controle.loginFuncionario();
					break;
				default:
					break;
			}
		}
		
	}


}
