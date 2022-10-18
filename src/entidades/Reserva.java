package entidades;

public class Reserva {


	private int numeroQuarto;
	private int diaEntrada;
	private int mesEntrada;
	private int anoEntrada;
	private int diaSaida;
	private int mesSaida;
	private int anoSaida;
	private double diariaTotal;
	private Cliente cliente;
	private Funcionario funcionario;
	
	public Reserva(int numeroQuarto, int diaEntrada, int mesEntrada, int anoEntrada,
			int diaSaida, int mesSaida, int anoSaida, double diariaTotal, Funcionario funcionario, Cliente cliente) {
		
		this.numeroQuarto = numeroQuarto;
		this.diaEntrada = diaEntrada;
		this.mesEntrada = mesEntrada;
		this.anoEntrada = anoEntrada;
		this.diaSaida = diaSaida;
		this.mesSaida = mesSaida;
		this.anoSaida = anoSaida;
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.diariaTotal = diariaTotal;
	}
	
	public double getDiariaTotal() {
		return diariaTotal;
	}
	
	public void setDiariaTotal(double diariaTotal) {
		this.diariaTotal = diariaTotal;
	}

	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Funcionario getFuncionario() {
		return this.funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public int getNumeroQuarto() {
		return numeroQuarto;
	}
	
	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	
	public int getDiaEntrada() {
		return diaEntrada;
	}

	public void setDiaEntrada(int diaEntrada) {
		this.diaEntrada = diaEntrada;
	}

	public int getMesEntrada() {
		return mesEntrada;
	}

	public void setMesEntrada(int mesEntrada) {
		this.mesEntrada = mesEntrada;
	}

	public int getAnoEntrada() {
		return anoEntrada;
	}

	public void setAnoEntrada(int anoEntrada) {
		this.anoEntrada = anoEntrada;
	}

	public int getDiaSaida() {
		return diaSaida;
	}

	public void setDiaSaida(int diaSaida) {
		this.diaSaida = diaSaida;
	}

	public int getMesSaida() {
		return mesSaida;
	}

	public void setMesSaida(int mesSaida) {
		this.mesSaida = mesSaida;
	}

	public int getAnoSaida() {
		return anoSaida;
	}

	public void setAnoSaida(int anoSaida) {
		this.anoSaida = anoSaida;
	}
	
	
}
