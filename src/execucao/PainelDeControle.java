package execucao;

import java.util.ArrayList;
import java.util.Scanner;
import entidades.Cliente;
import entidades.Funcionario;
import entidades.Funcionario.Admin;
import entidades.Funcionario.Diretor;
import entidades.Funcionario.Geral;
import entidades.Funcionario.Gerente;
import entidades.Quarto;
import entidades.Reserva;
import funcionalidadesPadrao.Calendario;

public class PainelDeControle {
	
	// scanner
	Scanner entrada = new Scanner(System.in);
	
	// arrays
	ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	ArrayList<Quarto> listaQuartos = Quarto.getListaQuartos();
	ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();

	
	// undone
	public void registrarCliente(Funcionario funcionario) {
		Funcionario funcionarioResponsavel = funcionario;
		String nomeTitular, cpfTitular, idadeTitular;
		int numeroQuarto = 0, pessoas;
		boolean hospedado = false;
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("Você deve registrar o cliente inserindo as informações abaixo:");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		
		System.out.println("Digite o nome do cliente: ");
		nomeTitular = entrada.next();
		entrada.nextLine();
	
		System.out.println("Digite o CPF do cliente: ");
		cpfTitular = entrada.nextLine();
		
		System.out.println("Digite a idade do cliente: ");
		idadeTitular = entrada.nextLine();
		
		System.out.println("Digite quantas pessoas estão junto ao cliente: ");
		pessoas = entrada.nextInt();
		
		Cliente novoCliente = new Cliente (nomeTitular, cpfTitular, idadeTitular, pessoas, numeroQuarto, hospedado, 
				funcionarioResponsavel);
		listaClientes.add(novoCliente);
		System.out.println("Cliente criado com sucesso.");
		
	}
	
	public void criarReserva(Funcionario funcionario) {
		Cliente cliente = null;
		String nomeCliente;
		boolean clienteExiste = false, quartoExiste = false, quartoVerificado = false, quartoVago = true;
		int numeroQuarto = 0, diaEntrada = 0, mesEntrada = 0, anoEntrada = 0, diaSaida = 0, mesSaida = 0, 
				anoSaida = 0;
		double diariaTotal = 0, diariaQuarto = 0;
	
		
		while (!clienteExiste)	{
			System.out.println("Digite o nome do cliente: ");
			nomeCliente = entrada.next();
			
			for (int i = 0; i < listaClientes.size(); i++) {
				if (nomeCliente.equals(listaClientes.get(i).getNomeTitular())) {
					cliente = listaClientes.get(i);
					clienteExiste = true;
					break;
				}
			}
		}
	
		
		while (!quartoExiste) {
			System.out.println("Agora, digite o número do quarto que o cliente quer: ");
			numeroQuarto = entrada.nextInt();
			
			for (int i = 0; i < listaQuartos.size(); i++) {
				if (numeroQuarto == listaQuartos.get(i).getNumeroQuarto()) {
					System.out.println("O quarto existe.");
					diariaQuarto = listaQuartos.get(i).getDiariaQuarto();
					quartoExiste = true;
					break;
				}
			}
			if (!quartoExiste) {
				System.out.println("O quarto digitado não existe. Tente novamente.");
			}
		}
		
		while (!quartoVerificado) {
			System.out.println("");
			System.out.println("Precisamos agora dos dados de entrada e saída do cliente.");
			System.out.println("");
			
			System.out.println("Digite o dia de entrada: ");
			diaEntrada = entrada.nextInt();
			
			System.out.println("Digite o mês de entrada: ");
			mesEntrada = entrada.nextInt();
			
			System.out.println("Digite o ano de entrada: ");
			anoEntrada = entrada.nextInt();
			
			System.out.println("Digite o dia de saída: ");
			diaSaida = entrada.nextInt();
			
			System.out.println("Digite o mês de saída: ");
			mesSaida = entrada.nextInt();
			
			System.out.println("Digite o ano de saída: ");
			anoSaida = entrada.nextInt();
			
			Calendario calcularCalendario = new Calendario();
			boolean estaOcupadoEntrada = false;
			boolean estaOcupadoSaida = false;
			
			for (int i = 0; i < listaReservas.size(); i++) {
				if (numeroQuarto == listaReservas.get(i).getNumeroQuarto()) {
					//quarto já tem reserva, checar se as datas batem
					estaOcupadoEntrada = calcularCalendario.entreDatas(listaReservas.get(i).getDiaEntrada(), 
							listaReservas.get(i).getMesEntrada(), 
							listaReservas.get(i).getAnoEntrada(), 
							listaReservas.get(i).getDiaSaida(), 
							listaReservas.get(i).getMesSaida(), 
							listaReservas.get(i).getAnoSaida(), 
							diaEntrada, mesEntrada, anoSaida);
					
					estaOcupadoSaida = calcularCalendario.entreDatas(listaReservas.get(i).getDiaEntrada(), 
							listaReservas.get(i).getMesEntrada(), 
							listaReservas.get(i).getAnoEntrada(), 
							listaReservas.get(i).getDiaSaida(), 
							listaReservas.get(i).getMesSaida(), 
							listaReservas.get(i).getAnoSaida(), 
							diaSaida, mesSaida, anoSaida);
					
					if (estaOcupadoEntrada || estaOcupadoSaida) {
						System.out.println("O quarto já está ocupado para estas datas. Tente outras datas.");
						quartoVago = false;
						break;
					}
					else {
						quartoVago = true;
						quartoVerificado = true;
						break;
					}
				}
				
			}
		
			if (quartoVago)	 {
				quartoVerificado = true;
				diariaTotal = calcularCalendario.diferencaDias(diaEntrada, mesEntrada, anoSaida, 
						diaSaida, mesSaida, anoSaida) * diariaQuarto;
			}
		
		}
		
		
		
		Reserva novaReserva = new Reserva(numeroQuarto, diaEntrada, mesEntrada, anoEntrada,
				diaSaida, mesSaida, anoSaida, diariaTotal, funcionario, cliente);
		cliente.setHospedagem(true);
		listaReservas.add(novaReserva);
		System.out.println("A reserva foi criada com sucesso.");	
		
	}
	
	public void deletarReserva() {
		String nomeCliente;
		boolean reservaEncontrada = false;
		
		while (!reservaEncontrada) {	
			System.out.println("Digite o nome do cliente que reservou o quarto: ");
			nomeCliente = entrada.next();
			
			for (int i = 0; i < listaReservas.size(); i++) {
				if (nomeCliente.equals(listaReservas.get(i).getCliente().getNomeTitular())) {
					listaReservas.remove(i);
					System.out.println("Reserva encontrada e removida com sucesso.");
					reservaEncontrada = true;
					break;
				}
			}
		}
	}
	
	public void registrarFuncionario() {
		
		String nome, cpf, senha;
		int escolha;
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("Você deve registrar o funcionário inserindo as informações abaixo:");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		
		System.out.println("Digite o nome do funcionário: ");
;		nome = entrada.next();
	
		System.out.println("Digite o CPF do funcionário: ");
		cpf = entrada.next();
		
		System.out.println("Digite uma senha para este funcionário: ");
		senha = entrada.next();
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("Agora, precisamos saber que tipo de funcionário ele é.");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		
		System.out.println("Digite: 1 - Funcionário Comum | 2 - Gerente | 3 - Diretor | 4 - Admin");
		escolha = entrada.nextInt();
		
		switch (escolha) {
		
			case 1:
				Geral funcionarioGeral = new Funcionario(nome, cpf, senha).new Geral(nome, cpf, senha);
				listaFuncionarios.add(funcionarioGeral);
				System.out.println("Funcionário criado com sucesso.");
				break;
				
			case 2:
				Gerente funcionarioGerente = new Funcionario(nome, cpf, senha).new Gerente(nome, cpf, senha);
				listaFuncionarios.add(funcionarioGerente);
				System.out.println("Funcionário criado com sucesso.");
				break;
				
			case 3:
				Diretor funcionarioDiretor = new Funcionario(nome, cpf, senha).new Diretor(nome, cpf, senha);
				listaFuncionarios.add(funcionarioDiretor);
				System.out.println("Funcionário criado com sucesso.");
				break;
			
			case 4:
				Admin funcionarioAdmin = new Funcionario(nome, cpf, senha).new Admin(nome, cpf, senha);
				listaFuncionarios.add(funcionarioAdmin);
				System.out.println("Funcionário criado com sucesso.");
				break;
				
			default:
				break;
				
		}
	}
	
	public void registrarQuarto() {
		
		int numeroQuarto, classificacaoQuarto;
		String andarQuarto;
		boolean continuarRegistrando = true;
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("Você deve registrar um quarto inserindo as informações abaixo:");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		
		
		while (continuarRegistrando) {
			
			System.out.println("Digite o número para o quarto (padrão ANDAR_0_AP, EXEMPLO '601' - andar 6, primeiro apartamento): ");
			numeroQuarto = entrada.nextInt();
			
			for (int i = 0; i < listaQuartos.size(); i++) {
				if (listaQuartos.get(i).getNumeroQuarto() == numeroQuarto) {
					System.out.println("O quarto já existe, então você não pode criar ele.");
					continuarRegistrando = false;
					break;
				}
			}
			
			System.out.println("Digite o andar do quarto: ");
			andarQuarto = entrada.next();
			
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			System.out.println("Agora você precisa digitar a classificação do quarto.");
			System.out.println("1 - Quarto Solteiro | 2 - Quarto Casal | 3 - Quarto Família");
			System.out.println("4 - Quarto Hospedagem | 5 - Quarto Deluxe");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			classificacaoQuarto = entrada.nextInt();
			
			Quarto novoQuarto = new Quarto(numeroQuarto, classificacaoQuarto, andarQuarto);
			listaQuartos.add(novoQuarto);
			System.out.println("Quarto criado com sucesso. Agora vê a conta com os pedreiros.");
			continuarRegistrando = false;
		}
		
	}
	
	public void consultarQuartosDesocupados() {
		
		System.out.println("Os quartos desocupados (sem reservas) são: ");
		for (int i = 0; i < listaQuartos.size(); i++) {
			
			for (int j = 0; j < listaReservas.size(); j++) {
				if (!(listaQuartos.get(i).getNumeroQuarto() == listaReservas.get(j).getNumeroQuarto())) {
					System.out.println("Quarto: " + listaQuartos.get(i).getNumeroQuarto());
				}
			}
			
		}
		System.out.println("Lista finalizada.");
	}
	
	public void listarReservas() {
		
		for (int i = 0; i < listaReservas.size(); i++) {
			String dataEntradaFormatada = listaReservas.get(i).getDiaEntrada() + "/" 
					+ listaReservas.get(i).getMesEntrada() + "/" + listaReservas.get(i).getAnoEntrada(); 
			String dataSaidaFormatada = listaReservas.get(i).getDiaSaida() + "/" 
					+ listaReservas.get(i).getMesSaida() + "/" + listaReservas.get(i).getAnoSaida();
			
			System.out.println("QUARTO N°: " + listaReservas.get(i).getNumeroQuarto());
			System.out.println("Reservado por: " + listaReservas.get(i).getCliente().getNomeTitular());
			System.out.println("Da data " + dataEntradaFormatada + " até " + dataSaidaFormatada);
			System.out.println("Reserva efetuada pelo funcionário: " + listaReservas.get(i).getFuncionario().getNome());
			System.out.println("");
		}
		
	}
	
	public void listarClientes() {
		System.out.println("Clientes Registrados: \n");
		for (int i = 0; i < listaClientes.size(); i++) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("Nome do Cliente: " + listaClientes.get(i).getNomeTitular());
			System.out.println("CPF do Cliente: " + listaClientes.get(i).getCpfTitular());
			System.out.println("Criado por: " + listaClientes.get(i).getFuncionario().getNome());
			System.out.println("-----------------------------------------------------------------");
		}
	}

	public Funcionario loginFuncionario() {
		
		Admin funcionarioAdmin = new Funcionario("root", "0", "1234567").new Admin("root", "0", "1234567");
		listaFuncionarios.add(funcionarioAdmin);
		
		Funcionario funcionario = null;
		String nome, senha;
		boolean loginSucesso = false;
		
		while (!loginSucesso) {
			System.out.println("Digite o usuário: ");
			nome = entrada.next();
			
			System.out.println("Digite, agora, a senha: ");
			senha = entrada.next();
			
			for (int i = 0; i < listaFuncionarios.size(); i++) {
				if (nome.equals(listaFuncionarios.get(i).getNome())) {
					if (senha.equals(listaFuncionarios.get(i).getSenhaAcesso())) {
						System.out.println("Você conseguiu se autenticar.");
						funcionario = listaFuncionarios.get(i);
						loginSucesso = true;
						break;
					}
				}
			}
		
		}
		
		return funcionario;
	}
	
	public void receitaHospedagens() {
		double receita = 0;
		for (int i = 0; i < listaReservas.size(); i++) {
			receita += listaReservas.get(i).getDiariaTotal();
			
		}
		System.out.println("A receita é: R$" + receita);
	}
	
}